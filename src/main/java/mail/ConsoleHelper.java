package mail;

import java.util.Scanner;

public class ConsoleHelper implements Input {
    private static Scanner scanner = new Scanner(System.in);


    public int askCommand() {
        int rsl = 0;
        try {
            rsl = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Неправильная коммандна");
            askCommand();
        }
        return rsl;
    }

    public String ask() {
        return scanner.next();
    }
}
