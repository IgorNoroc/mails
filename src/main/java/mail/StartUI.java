package mail;

public class StartUI {
    private Mail mail = new Mail();

    public static void main(String[] args) {
        new StartUI().init(new ConsoleHelper());
    }

    /**
     * Инициализация меню и выбор действия.
     *
     * @param input входные данные.
     */
    public void init(Input input) {
        int insert = 0;
        while (insert != 3) {
            showMenu();
            insert = input.askCommand();
            if (insert == 1) {
                chooseAddUser(input);
                System.out.println("---------------------------");
            }
            if (insert == 2) {
                mail.getUsers().forEach((k, v) -> System.out.println(k.getName() + " = " + v));
                System.out.println("---------------------------");
            }
        }
    }

    /**
     * Спомогательный метод при выборе:
     * добавить пользователя
     * в методе init().
     * Создает и добавляет пользователя
     * в хранилище.
     *
     * @param input входные данные.
     */
    private void chooseAddUser(Input input) {
        System.out.println("Введите имя пользователя:");
        String name = input.ask();
        User user = new User(name);
        System.out.println("Ведите один или несколько электроных адресов: ");
        System.out.println("---для завершения ввода адрессов введите \"exit\"---");
        String email;
        while (true) {
            email = input.ask();
            if (email.equals("exit")) {
                break;
            }
            user.addEmails(email);
        }
        mail.addUser(user);
    }

    /**
     * Меню.
     */
    private void showMenu() {
        System.out.println("Выберите пожалуйтса комманду: ");
        System.out.println("1. Добавить пользователя.");
        System.out.println("2. Все пользователи");
        System.out.println("3. Выход");
    }

    public Mail getMail() {
        return mail;
    }
}
