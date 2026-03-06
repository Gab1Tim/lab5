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
            System.out.println("Usage: execute_script <file_name>");
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }

        if (!file.canRead()) {
            System.out.println("Cannot read file (permission denied): " + fileName);
            return;
        }

        try {
            Scanner fileScanner = new Scanner(file);
            InputManager.setFileInput(fileScanner);

            System.out.println("Running script: " + fileName);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;

                System.out.println("> " + line);

                try {
                    commandManager.executeCommand(line);
                } catch (InputManager.ScriptInputException e) {
                    System.out.println("Script error: " + e.getMessage());
                    System.out.println("Script stopped. Please fix your script and try again.");
                    break;
                } catch (Exception e) {
                    System.out.println("Script error: " + e.getMessage());
                    System.out.println("Script stopped. Please fix your script and try again.");
                    break;
                }
            }

            fileScanner.close();
            System.out.println("Script finished: " + fileName);

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            InputManager.restoreConsoleInput();
        }
    }
}