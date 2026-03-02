import commands.*;
import managers.CollectionManager;
import managers.CommandManager;
import managers.InputManager;

public class Main {

    public static void main(String[] args) {

        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager();

        // Komutları register et
        commandManager.registerCommand(new InsertCommand(collectionManager));
        commandManager.registerCommand(new ShowCommand(collectionManager));
        commandManager.registerCommand(new InfoCommand(collectionManager));
        commandManager.registerCommand(new RemoveKeyCommand(collectionManager));
        commandManager.registerCommand(new ClearCommand(collectionManager));
        commandManager.registerCommand(new HelpCommand(commandManager));
        commandManager.registerCommand(new ExitCommand());

        System.out.println("Welcome! Type commands:");

        while (true) {
            String inputLine = InputManager.readLine("> ");
            if (inputLine.equalsIgnoreCase("exit")) break;
            commandManager.executeCommand(inputLine);
        }

        System.out.println("Program terminated.");
    }
}