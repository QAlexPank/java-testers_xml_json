package ru.gb.qalex.deserializer;

import ru.gb.qalex.model.User;

import java.util.Collection;

public interface UserDeserializer {

    Collection<User> deseralize(String inFileName);

}
