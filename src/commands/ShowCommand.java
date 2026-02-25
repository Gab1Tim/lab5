package commands;

import managers.CollectionManager;

public class ShowCommand  implements Command {

    private CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "Shows the collection";
    }

    @Override
    public void execute(String[] args) {
        collectionManager.show();
    }
}
