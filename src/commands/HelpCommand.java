package commands;

import managers.CommandManager;

public class HelpCommand implements Command {

    private CommandManager commandManager;

    public HelpCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public String getName() {
        return "help";
    }
    public String getDescription() {
        return "Displays a list of available commands";
    }

    public void execute(String[] commands) {
        commandManager.showAllCommands();
    }

}
