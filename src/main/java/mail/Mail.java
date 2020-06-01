package mail;

import java.util.*;

public class Mail {
    private Map<User, Set<String>> users = new HashMap<>();
    private Map<String, User> store = new HashMap<>();

    /**
     * Добавляем пользователя.
     * Все электронные адреса сохраняются в хранилище "store",
     * при этом сохнаняя ссылку пользоватебя в карте пользователей.
     * При добавление нового пользователя, проверяется есть ли такой
     * электронный адрес в хранилище.
     * Если есть совпадение, все адреса текущего пользователя
     * перезаписываются в список пользователя, где было совпадение.
     *
     * @param user пользователь.
     */
    public void addUser(User user) {
        boolean flag = false;
        User pointer = null;
        for (String email : user.getEmails()) {
            if (store.containsKey(email)) {
                flag = true;
                pointer = store.get(email);
                break;
            }
        }
        if (!flag) {
            for (String email : user.getEmails()) {
                store.put(email, user);
            }
            users.put(user, user.getEmails());
        } else {
            for (String email : user.getEmails()) {
                store.put(email, pointer);
            }
            pointer.getEmails().addAll(user.getEmails());
            users.replace(pointer, pointer.getEmails());
        }
    }

    /**
     * Список пользователей.
     *
     * @return список.
     */
    public Map<User, Set<String>> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mail mail = (Mail) o;
        return Objects.equals(users, mail.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
