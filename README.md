## Потоки ввода-вывода, XML+JSON.

### Практическое задание

Создать файл из 10 строк вида (с заголовком)
id;name;email
1;Ivan;ivan@mail.ru
....
10;Sergey;sergey@live.ru

Создать интерфейсы
*UserDeserializer*, который принимает на вход имя файла (путь), а на выход отдает Collection<User>
UserSerializer, который принимает на вход Collection<User> и имя файла. На выход ничего не отдает.

Создать класс User само собой придется.
У вас должно быть по 3 реализации:
*CsvUserSerializer*
*JsonUserSerializer*
*XmlUserSerializer*
И еще 3 десериалайзера.

При помощи библиотеки Jackson(json, xml, csv) и класса ObjectMapper реализовать:
1. Запись списка пользователей в файл
2. Превращение файла в список пользователей.

При помощи тестов подтвердить, что как минимум файл не пустой.
Превратить пользователя при помощи Serializer-a в json-файл и потом при помощи Deserializer-а превратить обратно в список пользователей и сравнить их с оригинальным.