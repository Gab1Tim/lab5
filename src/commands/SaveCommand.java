package commands;

import managers.CollectionManager;
import managers.InputManager;

public class SaveCommand implements Command {

    private CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "Saves the collection to a JSON file";
    }

    @Override
    public void execute(String[] args) {
        try {
            String fileName = System.getenv("FILE_NAME");
            if (fileName == null || fileName.isEmpty()) {
                fileName = InputManager.readLine("Enter file name to save: ");
            }

            collectionManager.saveCollection(fileName);

        } catch (Exception e) {
            System.out.println("Error while saving collection: " + e.getMessage());
        }
    }
}