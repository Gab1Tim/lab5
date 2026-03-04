package managers;

import models.Address;
import models.Coordinates;
import models.Organization;
import models.OrganizationType;
import java.util.Scanner;


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
    public static Organization readOrganization() {
        try {
            String name = readLine("Enter name: ");

            double x = readDouble("Enter x (must be > -915): ");
            int y = readInt("Enter y: ");
            Coordinates coordinates = new Coordinates(x, y);
            int annualTurnover = readInt("Enter annualTurnover (>0): ");
            String typeInput = readLine("Enter type (COMMERCIAL, GOVERNMENT, TRUST, PRIVATE_LIMITED_COMPANY, OPEN_JOINT_STOCK_COMPANY) or empty for null: ");
            OrganizationType type = null;
            if (!typeInput.isEmpty()) {
                type = OrganizationType.valueOf(typeInput.trim().toUpperCase());
            }
            String zip = readLine("Enter zipCode (or empty for null): ");
            if (zip.isEmpty()) zip = null;
            Address address = new Address(zip);
            return new Organization(name, coordinates, annualTurnover, type, address);

        } catch (Exception e) {
            System.out.println("Invalid input, try again.");
            return readOrganization();
        }
    }
    public static void setFileInput(Scanner fileScanner) {
        scanner = fileScanner;
    }

    public static void restoreConsoleInput() {
        scanner = originalScanner;
    }

}