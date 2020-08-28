package ru.gb.qalex.deserializer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.gb.qalex.model.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUserDeserializer implements UserDeserializer{

    @Override
    public List<User> deseralize(String inFileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        File inFile = new File(inFileName);


        try {
            MappingIterator<User> it = objectMapper.readerFor(User.class).readValues(inFile);
            return it.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
