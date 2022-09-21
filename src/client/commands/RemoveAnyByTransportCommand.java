package client.commands;

import client.network.RequestSender;
import common.Request;
import common.Response;
import common.ResponseCode;

public class RemoveAnyByTransportCommand implements Command {
    RequestSender requestSender;

    public RemoveAnyByTransportCommand(RequestSender requestSender) {
        this.requestSender = requestSender;
    }

    @Override
    public String getName() {
        return "remove_any_by_transport";
    }

    @Override
    public String getDescription() {
        return "remove_any_by_transport: удалить из коллекции один элемент, значение поля transport которого эквивалентно заданному";
    }

    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) {
                throw new IllegalArgumentException();
            }
            Request<String> request = new Request<>("remove_any_by_transport", argument);
            Response response = requestSender.sendRequest(request);
            if (response.getResponseCode() == ResponseCode.OK) {
                System.out.println(response.getResponseBody());
            } else {
                System.err.println(response.getResponseBody());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Аргумент не поступил.");
        }
    }
}
