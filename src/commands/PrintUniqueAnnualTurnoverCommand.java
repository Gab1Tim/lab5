package commands;

import managers.CollectionManager;

public class PrintUniqueAnnualTurnoverCommand implements Command {

    private CollectionManager collectionManager;

    public PrintUniqueAnnualTurnoverCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName() {
        return "print_unique_annual_turnover";
    }

    @Override
    public String getDescription() {
        return "Prints all unique annualTurnover values of the organizations in the collection";
    }

    @Override
    public void execute(String[] args) {
        collectionManager.printUniqueAnnualTurnover();
    }
}