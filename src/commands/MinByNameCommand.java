package commands;

import managers.CollectionManager;
import models.Organization;

public class MinByNameCommand implements Command {

    private CollectionManager collectionManager;

    public MinByNameCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName() {
        return "min_by_name";
    }

    @Override
    public String getDescription() {
        return "Prints the organization with the smallest name (alphabetically)";
    }

    @Override
    public void execute(String[] args) {
        Organization minOrg = collectionManager.getMinByName();
        if (minOrg != null) {
            System.out.println("Organization with the smallest name:");
            System.out.println(minOrg);
        } else {
            System.out.println("Collection is empty!");
        }
    }
}