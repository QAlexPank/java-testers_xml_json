package ru.gb.qalex.serializer;

import ru.gb.qalex.model.User;

import java.util.Collection;

public interface UserSerializer {

     void serialize(Collection<User> userCollection, String outFileName);
}
