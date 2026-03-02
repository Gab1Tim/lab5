package commands;

import managers.CollectionManager;

public class ClearCommand implements Command {

    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "Clears the entire collection";
    }

    @Override
    public void execute(String[] args) {
        collectionManager.clear();
        System.out.println("Collection cleared successfully!");
    }
}