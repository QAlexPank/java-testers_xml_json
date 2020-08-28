package ru.gb.qalex;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import ru.gb.qalex.deserializer.CsvUserDeserializer;
import ru.gb.qalex.deserializer.JsonUserDeserializer;
import ru.gb.qalex.deserializer.UserDeserializer;
import ru.gb.qalex.deserializer.XmlUserDeserializer;
import ru.gb.qalex.model.User;
import ru.gb.qalex.serializer.CsvUserSerializer;
import ru.gb.qalex.serializer.JsonUserSerializer;
import ru.gb.qalex.serializer.UserSerializer;
import ru.gb.qalex.serializer.XmlUserSerializer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserTest {

    @Test
    public void JsonUserTest(){
        File jsonFile = new File("users.json");
        Collection<User> userCollection = prepareUsers();
        UserSerializer userSerializer = new JsonUserSerializer();
        userSerializer.serialize(userCollection, jsonFile.getName());

        Assertions.assertThat(jsonFile).exists();
        Assertions.assertThat(jsonFile.length()).isGreaterThan(0);

        UserDeserializer userDeserializer = new JsonUserDeserializer();
        Collection<User> restoredUsers = userDeserializer.deseralize(jsonFile.getName());
        Assertions.assertThat(userCollection).containsExactlyElementsOf(restoredUsers);

    }

    @Test
    public void XmlUserTest(){
        File xmlFile = new File("users.xml");
        Collection<User> userCollection = prepareUsers();
        UserSerializer userSerializer = new XmlUserSerializer();
        userSerializer.serialize(userCollection, xmlFile.getName());

        Assertions.assertThat(xmlFile).exists();
        Assertions.assertThat(xmlFile.length()).isGreaterThan(0);

        UserDeserializer userDeserializer = new XmlUserDeserializer();

        Collection<User> restoredUsers = userDeserializer.deseralize(xmlFile.getName());
        Assertions.assertThat(userCollection).containsExactlyElementsOf(restoredUsers);
    }

    @Test
    public void CsvUserTest(){
        File csvFile = new File("users.csv");
        Collection<User> userCollection = prepareUsers();
        UserSerializer userSerializer = new CsvUserSerializer();
        userSerializer.serialize(userCollection, csvFile.getName());

        Assertions.assertThat(csvFile).exists();
        Assertions.assertThat(csvFile.length()).isGreaterThan(0);

        UserDeserializer userDeserializer = new CsvUserDeserializer();

        Collection<User> restoredUsers = userDeserializer.deseralize(csvFile.getName());
        Assertions.assertThat(userCollection).containsExactlyElementsOf(restoredUsers);
    }

    private List<User> prepareUsers(){
        ArrayList<User> userCollection = new ArrayList<User>();
        userCollection.add(new User(1, "Vasily Petrov", "petrov@mail.ru"));
        userCollection.add(new User(2, "Petr Vasechkin", "vasechkin@gmail.com"));
        userCollection.add(new User(3, "Semen Sidorov ", "sidorov@yandex.ru"));
        userCollection.add(new User(4, "Ivan Ivanov", "ivanov@yandex.ru"));
        userCollection.add(new User(5, "Alexandr Pushkin ", "pushkin@mail.ru"));
        userCollection.add(new User(6, "Vladimir Lenin ", "lenin@gmail.com"));
        userCollection.add(new User(7, "Josef Stalin ", "stalin@mail.ru"));
        userCollection.add(new User(8, "Mihail Lermontov ", "lermontov@yandex.ru"));
        userCollection.add(new User(9, "Yuri Gagarin ", "gagarin@mail.ru"));
        userCollection.add(new User(10, "Andrey Shevchenko ", "shevchenko@gmail.com"));
        return userCollection;
    }

}
