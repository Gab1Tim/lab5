package commands;

import managers.CommandManager;
import managers.InputManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {

    private final CommandManager commandManager;

    public ExecuteScriptCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "execute_script file_name : execute commands from the specified file";
    }

    @Override
    public void execute(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: execute_script with file_name");
            return;
        }

        String fileName = args[0];

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }

        try {
            Scanner fileScanner = new Scanner(file);

            InputManager.setFileInput(fileScanner);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (!line.isEmpty()) {
                    System.out.println("> " + line);
                    commandManager.executeCommand(line);
                }
            }
            fileScanner.close();
            InputManager.restoreConsoleInput();

        }
        catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}