package managers;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class InputManager {

    private static Scanner scanner = new Scanner(System.in);
    private static final Scanner originalScanner = scanner;

    public static String readLine(String prompt) {
        System.out.print(prompt);
        if (scanner.hasNextLine()) {
            return scanner.nextLine().trim();
        } else {
            return null;
        }
    }

    public static int readInt(String prompt) {
        while (true) {
            String line = readLine(prompt);
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            String line = readLine(prompt);
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid double. Try again.");
            }
        }
    }

    public static void setFileInput(Scanner fileScanner) {
        scanner = fileScanner;
    }

    public static void restoreConsoleInput() {
        scanner = originalScanner;
    }

    public static void startInputLoop() {
        try {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Input error, exiting.");
            System.exit(0);
        }
    }
}