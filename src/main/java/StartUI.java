public class StartUI {
    private static Mail mail = new Mail();

    public static void main(String[] args) {
        new StartUI().init();
    }

    public void init() {
        showMenu();
        int insert = ConsoleHelper.askCommand();
        while (insert != 3) {
            if (insert == 1) {
                chooseAddUser();
                System.out.println("---------------------------");
            }
            if (insert == 2) {
                mail.getUsers().forEach(System.out::println);
                System.out.println("---------------------------");
            }
            init();
        }
    }

    private void chooseAddUser() {
        System.out.println("Введите имя пользователя:");
        String name = ConsoleHelper.ask();
        User user = new User(name);
        System.out.println("Ведите один или несколько электроных адресов: ");
        System.out.println("---для завершения ввода адрессов введите \"exit\"---");
        String email;
        while (true) {
            email = ConsoleHelper.ask();
            if (email.equals("exit")) {
                break;
            }
            user.addEmails(email);
        }
        mail.addUser(user);
    }

    private void showMenu() {
        System.out.println("Выберите пожалуйтса комманду: ");
        System.out.println("1. Добавить пользователя.");
        System.out.println("2. Все пользователи");
        System.out.println("3. Выход");
    }
}
