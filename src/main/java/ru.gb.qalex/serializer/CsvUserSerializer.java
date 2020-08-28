package ru.gb.qalex.serializer;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import ru.gb.qalex.model.User;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class CsvUserSerializer implements UserSerializer {

    @Override
    public void serialize(Collection<User> userCollection, String outFileName) {
        CsvMapper objectMapper = new CsvMapper();
        objectMapper.disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
        CsvSchema csvSchema = objectMapper
                                    .schemaFor(User.class)
                                    .withHeader();

        File out = new File(outFileName);
        try {

            objectMapper.writer(csvSchema).writeValue(out, userCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
