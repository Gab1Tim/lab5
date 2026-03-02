package commands;

import managers.CollectionManager;

public class InfoCommand implements Command {

    private CollectionManager  collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;

    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "Shows the collection";
    }

    @Override
    public void execute(String[] args){
        collectionManager.info();
    }

}
