package commands;

import managers.CollectionManager;

public class SaveCommand implements Command {

    private final CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "save : save the collection to file";
    }

    @Override
    public void execute(String[] args) {
        collectionManager.save();
        System.out.println("Collection successfully saved.");
    }
}