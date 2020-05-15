package mail;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenAdd3Users() {
        StubInput input = new StubInput(List.of(
                "1", "User1", "111.ru", "222.ru", "exit",
                "1", "User2", "333.ru", "444.ru", "exit",
                "1", "User3", "555.ru", "exit", "2",
                "3"
        ));
        StartUI startUI = new StartUI();
        startUI.init(input);
        User user1 = new User("User1");
        user1.addEmails("111.ru", "222.ru");
        User user2 = new User("User2");
        user2.addEmails("333.ru", "444.ru");
        User user3 = new User("User3");
        user3.addEmails("555.ru");
        Set<User> expected = Set.of(
               user1, user2, user3
        );
        assertThat(expected, is(startUI.getMail().getUsers()));
    }

    @Test
    public void whenHave2UserAnd1EqEmail() {
        StubInput input = new StubInput(List.of(
                "1", "User1", "111.ru", "222.ru", "exit",
                "1", "User2", "333.ru", "111.ru", "exit",
                "2", "3"
        ));
        StartUI startUI = new StartUI();
        startUI.init(input);
        User user1 = new User("User1");
        user1.addEmails("111.ru", "222.ru", "333.ru");
        Set<User> expected = Set.of(user1);
        assertThat(expected, is(startUI.getMail().getUsers()));
    }
}