package commands;

import managers.CollectionManager;
import managers.InputManager;
import models.Address;
import models.Coordinates;
import models.Organization;
import models.OrganizationType;

public class InsertCommand implements Command {
    private CollectionManager collectionManager;

    public InsertCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return "Inserts a new Organization with a unique key";
    }

    @Override
    public void execute(String[] args) {
        try {

            Integer key = null;
            while (true) {
                key = InputManager.readInt("Enter key (integer): ");
                if (collectionManager.containsKey(key)) {
                    System.out.println("Key already exists. Enter a different key.");
                } else {
                    break;
                }
            }

            String name = InputManager.readLine("Enter name: ");

            double x = InputManager.readDouble("Enter X coordinate (double): ");
            Integer y = InputManager.readInt("Enter Y coordinate (integer): ");
            Coordinates coordinates = new Coordinates(x, y);

            int turnover = InputManager.readInt("Enter annual turnover (int > 0): ");


            OrganizationType type = null;
            while (true) {
                String typeStr = InputManager.readLine(
                        "Enter Organization Type (COMMERCIAL, GOVERNMENT, TRUST, PRIVATE_LIMITED_COMPANY, OPEN_JOINT_STOCK_COMPANY): "
                );
                if (typeStr.isEmpty()) break;
                try {
                    type = OrganizationType.valueOf(typeStr);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid OrganizationType. Try again.");
                }
            }

            String zip = InputManager.readLine("Enter zip code (max 19 chars, can be empty): ");
            Address address = new Address(zip.isEmpty() ? null : zip);

            Organization org = new Organization(name, coordinates, turnover, type, address);
            collectionManager.insert(key, org);

            System.out.println("Organization added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}