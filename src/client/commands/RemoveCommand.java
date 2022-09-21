package client.commands;

import client.network.RequestSender;
import common.Request;
import common.Response;
import common.ResponseCode;

public class RemoveCommand implements Command {
    RequestSender requestSender;

    public RemoveCommand(RequestSender requestSender) {
        this.requestSender = requestSender;
    }

    @Override
    public String getName() {
        return "remove";
    }

    @Override
    public String getDescription() {
        return "remove: удалить элемент из коллекции по его id";
    }

    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) {
                throw new IllegalArgumentException();
            }
            Long id = Long.parseLong(argument);
            Request<Long> request = new Request<>("remove", id);
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
