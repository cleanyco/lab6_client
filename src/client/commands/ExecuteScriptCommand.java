package client.commands;

import client.network.RequestSender;
import client.util.ClientConsole;
import common.Request;
import common.Response;
import common.ResponseCode;
import client.commands.exceptions.ScriptRecursionException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class ExecuteScriptCommand implements Command {
    RequestSender requestSender;
    ClientConsole clientConsole;
    Stack<String> scriptStack = new Stack<>();

    public ExecuteScriptCommand(RequestSender requestSender, ClientConsole clientConsole) {
        this.requestSender = requestSender;
        this.clientConsole = clientConsole;
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "execute_script: считать и исполнить скрипт из указанного файла";
    }
    //TODO: закрыть Scanner
    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) {
                throw new IllegalArgumentException();
            }
            File file = new File(argument);
            if (!(file.canRead() && file.exists() && file.isFile())) throw new IOException();
            if (scriptStack.contains(argument)) throw new ScriptRecursionException();

            Scanner scriptScanner = new Scanner(file);
            System.out.println("Скрипт '" + argument + "' исполняется..." );
            scriptStack.add(argument);
            clientConsole.executeScript(scriptScanner);
            scriptStack.remove(argument);
//            Request<String> request = new Request<>("execute_script", argument);
//            Response response = requestSender.sendRequest(request);
//            if (response.getResponseCode() == ResponseCode.OK) {
//                System.out.println(response.getResponseBody());
//            } else {
//                System.err.println(response.getResponseBody());
//            }
        } catch (IllegalArgumentException e) {
            System.out.println("Аргумент не поступил.");
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл.");
        } catch (ScriptRecursionException e) {
            System.out.println("Рекурсивный вызов скрипта запрещён.");
        }
    }
}
