package mail;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    private String name;
    private Set<String> emails = new HashSet<>();

    public User(String name) {
        this.name = name;
    }

    /**
     * Добавляет один или несколько электронных адресов
     * пользователю.
     *
     * @param email электронный адрес или адреса.
     */
    public void addEmails(String... email) {
        emails.addAll(Arrays.asList(email));
    }

    public Set<String> getEmails() {
        return emails;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(emails, user.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emails);
    }

    @Override
    public String toString() {
        return "User: '" + name
                + '\''
                + ", emails=" + emails;
    }
}
