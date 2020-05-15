package mail;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Mail {
    private Set<User> users = new HashSet<>();

    /**
     * Добавляем пользователя.
     *
     * @param user пользователь.
     */
    public void addUser(User user) {
        boolean flag = false;
        for (User current : users) {
            if (containsEmail(current, user)) {
                current.getEmails().addAll(user.getEmails());
                flag = true;
            }
        }
        if (!flag) {
            users.add(user);
        }
    }

    /**
     * Проверка на уникальность электронных адресов.
     *
     * @param first  текущий пользователь.
     * @param second проверяемый пользователь
     * @return содержит или нет дубликаты проверяемый пользователь.
     */
    private static boolean containsEmail(User first, User second) {
        boolean rsl = false;
        Set<String> emails = first.getEmails();
        for (String email : emails) {
            if (second.getEmails().contains(email)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    /**
     * Список пользователей.
     *
     * @return список.
     */
    public Set<User> getUsers() {
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
