package client.util;

import client.commands.*;
import client.network.RequestSender;

import java.io.IOException;
import java.util.*;

public class ClientConsole {
    private final ArrayList<Command> commands = new ArrayList<>();
    private final RequestSender requestSender = new RequestSender();
    private Scanner sc = new Scanner(System.in);
    private final FlatRecorder flatRecorder = new FlatRecorder(sc);

    {
        commands.add(new AddCommand(requestSender, flatRecorder));
        commands.add(new ClearCommand(requestSender));
        commands.add(new ExecuteScriptCommand(requestSender, this));
        commands.add(new AddIfMaxCommand(requestSender, flatRecorder));
        commands.add(new AddIfMinCommand(requestSender, flatRecorder));
        commands.add(new ExitCommand(requestSender));
        commands.add(new HelpCommand(requestSender, this));
        commands.add(new InfoCommand(requestSender));
        commands.add(new PrintDescendingCommand(requestSender));
        commands.add(new RemoveAnyByTransportCommand(requestSender));
        commands.add(new RemoveCommand(requestSender));
        commands.add(new ShowCommand(requestSender));
        commands.add(new ShuffleCommand(requestSender));
        commands.add(new SumOfNumberOfBathroomsCommand(requestSender));
        commands.add(new UpdateCommand(requestSender, flatRecorder));
    }


    public void parseCommand(String input) {
        if (input.isEmpty()) {
            System.out.println("Введенная строка пуста.");
            throw new IllegalArgumentException();
        }
        String[] userInput = input.trim().split(" ");
        String command = userInput[0];
        String commandArgument;
        if (userInput.length > 1) {
            commandArgument = userInput[1];
        } else commandArgument = "";
        executeCommand(command, commandArgument);

    }
    public void executeCommand(String command, String argument) {
//        String[] args = input.trim().split(" ");
//        if (args.length == 0) {
//            System.out.println("Введённая строка пуста");
//        }
        //FIXME сделать компактнее
        try {
            boolean isFound = false;
           for (Command commandToFind: commands) {
               if (commandToFind.getName().equals(command.trim())) {
                   isFound = true;
                   if (isFound) {
                       break;
                   }
               }
           }
               if (!isFound) {
                   throw new IllegalArgumentException();
               }
        } catch (IllegalArgumentException e) {
            System.out.println("Такой команды не существует.");
        }

        try {
            commands.stream().filter(command1 -> command1.getName().equals(command))
                    .findFirst()
                    .get()
                    .execute(argument.trim());
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println("Ошибка запуска команды.");
        }
    }

    public void executeScript(Scanner scriptScanner) throws IOException {
        String input;
        flatRecorder.setUserScanner(scriptScanner);
        flatRecorder.setFileMode();
        do {
            if (!scriptScanner.hasNextLine()) return;
            input = scriptScanner.nextLine();
            while (input.isEmpty() && scriptScanner.hasNextLine()) {
                input = scriptScanner.nextLine();
            }
            try {
                parseCommand(input);
            } catch (Exception e) {
                System.out.println("Произошла непредвиденная ошибка при чтении скрипта, остановка...");
            }
            //FIXME what's purpose of this huh?
            System.out.println("");
        } while (!input.equals("exit"));
        flatRecorder.setUserMode();
        flatRecorder.setUserScanner(sc);
    }

    public void getHelp() {
        commands.forEach(command -> System.out.println(command.getDescription()));
    }
}
