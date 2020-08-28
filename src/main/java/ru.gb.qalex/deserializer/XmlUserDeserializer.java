package ru.gb.qalex.deserializer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.gb.qalex.model.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlUserDeserializer implements UserDeserializer {

    @Override
    public List<User> deseralize(String inFileName) {
        ObjectMapper objectMapper = new XmlMapper();
        File inFile = new File(inFileName);

 //       Collection<User> userCollection = new ArrayList<>();
        try {
            MappingIterator<User> it = objectMapper.readerFor(User.class).readValues(inFile);
            return it.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
