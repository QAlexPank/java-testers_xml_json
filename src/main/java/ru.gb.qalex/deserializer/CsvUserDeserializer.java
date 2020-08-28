package ru.gb.qalex.deserializer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import ru.gb.qalex.model.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvUserDeserializer implements UserDeserializer {

    @Override
    public List<User> deseralize(String inFileName) {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        File in = new File(inFileName);

        try {
            MappingIterator<User> it = csvMapper.readerFor(User.class).with(csvSchema).readValues(in);
            return it.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
