import commands.*;
import managers.CollectionManager;
import managers.CommandManager;
import managers.FileManager;
import managers.InputManager;

public class Main {

    public static void main(String[] args) {

        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager();

        commandManager.registerCommand(new InsertCommand(collectionManager));
        commandManager.registerCommand(new ShowCommand(collectionManager));
        commandManager.registerCommand(new InfoCommand(collectionManager));
        commandManager.registerCommand(new RemoveKeyCommand(collectionManager));
        commandManager.registerCommand(new ClearCommand(collectionManager));
        commandManager.registerCommand(new HelpCommand(commandManager));
        commandManager.registerCommand(new ExitCommand());
        commandManager.registerCommand(new HistoryCommand(commandManager));
        commandManager.registerCommand(new UpdateCommand(collectionManager));
        commandManager.registerCommand(new RemoveGreaterKeyCommand(collectionManager));
        commandManager.registerCommand(new MinByNameCommand(collectionManager));
        commandManager.registerCommand(new FilterGreaterThanTypeCommand(collectionManager));
        commandManager.registerCommand(new PrintUniqueAnnualTurnoverCommand(collectionManager));
        commandManager.registerCommand(new SaveCommand(collectionManager));

        System.out.println("Welcome! Type commands:");

        while (true) {
            String inputLine = InputManager.readLine("> ");
            if (inputLine.equalsIgnoreCase("exit")) break;
            commandManager.executeCommand(inputLine);
        }

        System.out.println("Program terminated.");
    }
}