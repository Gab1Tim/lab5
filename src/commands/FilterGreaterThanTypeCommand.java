package commands;

import managers.CollectionManager;
import managers.InputManager;
import models.Organization;
import models.OrganizationType;

public class FilterGreaterThanTypeCommand implements Command {

    private CollectionManager collectionManager;

    public FilterGreaterThanTypeCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName() {
        return "filter_greater_than_type";
    }

    @Override
    public String getDescription() {
        return "Prints organizations whose type is greater than the given type";
    }

    @Override
    public void execute(String[] args) {
        try {
            String typeStr = InputManager.readLine("Enter Organization Type (COMMERCIAL, GOVERNMENT, TRUST, PRIVATE_LIMITED_COMPANY, OPEN_JOINT_STOCK_COMPANY): ");

            OrganizationType type = OrganizationType.valueOf(typeStr);

            collectionManager.filterGreaterThanType(type);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid OrganizationType. Try again.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}