package client.commands;

import client.network.RequestSender;
import common.Request;
import common.Response;
import common.ResponseCode;

public class PrintDescendingCommand implements Command {
    RequestSender requestSender;

    public PrintDescendingCommand(RequestSender requestSender) {
        this.requestSender = requestSender;
    }

    @Override
    public String getName() {
        return "print_descending";
    }

    @Override
    public String getDescription() {
        return "print_descending: вывести элементы коллекции в порядке убывания";
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new IllegalArgumentException();
            }
            Request<String> request = new Request<>("print_descending", null);
            Response response = requestSender.sendRequest(request);
            if (response.getResponseCode() == ResponseCode.OK) {
                System.out.println(response.getResponseBody());
            } else {
                System.err.println(response.getResponseBody());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Аргумент в данной команде не используется.");
        }
    }
}
