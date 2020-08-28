package ru.gb.qalex.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.gb.qalex.model.User;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class XmlUserSerializer implements UserSerializer{

    @Override
    public void serialize(Collection<User> userCollection, String outFileName) {
        ObjectMapper objectMapper = new XmlMapper();
        File out = new File(outFileName);
        try {
            objectMapper.writerFor(userCollection.getClass()).writeValue(out, userCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
