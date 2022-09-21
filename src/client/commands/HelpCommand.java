package client.commands;

import client.network.RequestSender;
import client.util.ClientConsole;
import common.Request;
import common.Response;
import common.ResponseCode;

//FIXME нужно ли добавлять сюда CommandManager?
public class HelpCommand implements Command {
    RequestSender requestSender;
    ClientConsole clientConsole;

    public HelpCommand(RequestSender requestSender, ClientConsole clientConsole) {
        this.requestSender = requestSender;
        this.clientConsole = clientConsole;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "help: вывести справку по доступным командам";
    }

    //FIXME добавить в CollectionManager CommandManager?
    /*
    Команды "подготавливаются" на клиенте, а отправляются для выполнения на сервер
    Но команду Help и CommandManager не нужно держать на сервере (как выполнить скрипт на сервере?)
     */
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new IllegalArgumentException();
            }
            clientConsole.getHelp();
//            Request<String> request = new Request<>("help", null);
//            Response response = requestSender.sendRequest(request);
//            if (response.getResponseCode() == ResponseCode.OK) {
//                System.out.println(response.getResponseBody());
//            } else {
//                System.err.println(response.getResponseBody());
//            }
        } catch (IllegalArgumentException e) {
            //FIXME сделать нормальный вывод ошибок.
            //FIXME можно просто написать "непредвиденная ошибка!"
            System.out.println("Аргумент в данной команде не используется.");
        }
    }
}
