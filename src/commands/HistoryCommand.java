package commands;

import managers.CommandManager;

public class HistoryCommand implements Command {

    private CommandManager  commandManager;

    public HistoryCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public String getName () {
        return "history";
    }
    @Override
    public String getDescription () {
        return "Shows last 12 commands";
    }
    @Override
    public void execute(String [] args) {
        commandManager.showHistory();
    }
}


