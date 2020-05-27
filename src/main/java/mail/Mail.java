package mail;

import java.util.*;

public class Mail {
    private List<User> users = new ArrayList<>();
    private Map<String, Integer> store = new HashMap<>();
    private int point = 0;

    /**
     * Добавляем пользователя.
     * Все электронные адреса сохраняются в хранилище "store",
     * при этом сохнаняя индекс пользоватебя в списке пользователей.
     * При добавление нового пользователя, проверяется есть ли такой
     * электронный адрес в хранилище.
     * Если есть совпадение, все адреса текущего пользователя
     * перезаписываются в список пользователя, где было совпадение.
     *
     * @param user пользователь.
     */
    public void addUser(User user) {
        boolean flag = false;
        int tempIndex = -1;
        for (String email : user.getEmails()) {
            if (!store.containsKey(email)) {
                store.put(email, point);
            } else {
                tempIndex = store.get(email);
                flag = true;
            }
        }
        if (!flag) {
            users.add(user);
            point++;
        } else {
            users.get(tempIndex).getEmails()
                    .addAll(user.getEmails());
            for (Map.Entry<String, Integer> pair : store.entrySet()) {
                if (pair.getValue() == point) {
                    store.replace(pair.getKey(), tempIndex);
                }
            }
        }
    }

    /**
     * Список пользователей.
     *
     * @return список.
     */
    public List<User> getUsers() {
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
