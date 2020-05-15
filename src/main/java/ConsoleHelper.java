import java.util.Scanner;

public class ConsoleHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static int askCommand() {
        int rsl = 0;
        try {
            rsl = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Неправильная коммандна");
            askCommand();
        }
        return rsl;
    }

    public static String ask() {
        return scanner.next();
    }
}
