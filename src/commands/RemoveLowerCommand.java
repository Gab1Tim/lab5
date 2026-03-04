package commands;

import managers.CollectionManager;
import managers.InputManager;
import models.Organization;

public class RemoveLowerCommand implements Command {

    private CollectionManager collectionManager;
    private InputManager inputManager;

    public RemoveLowerCommand(CollectionManager collectionManager, InputManager inputManager) {
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
    }

    @Override
    public String getName() {
        return "remove_lower";
    }

    @Override
    public String getDescription() {
        return "Removes all elements lower than the given element (controls by annual turnover)";
    }

    @Override
    public void execute(String[] args) {
        Organization reference = inputManager.readOrganization();
        int removed = collectionManager.removeLower(reference);
        System.out.println(removed + " elements removed.");
    }
}