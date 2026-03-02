package commands;

import managers.CollectionManager;
import managers.InputManager;

public class RemoveGreaterKeyCommand implements Command {

    private CollectionManager collectionManager;

    public RemoveGreaterKeyCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName() {
        return "remove_greater_key";
    }

    @Override
    public String getDescription() {
        return "Removes all organizations with key greater than the given key";
    }

    @Override
    public void execute(String[] args) {
        try {
            Integer key = InputManager.readInt("Enter the key to compare: ");
            collectionManager.removeGreaterKey(key);
            System.out.println("All organizations with key greater than " + key + " have been removed!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}