package client.commands;

import client.network.RequestSender;
import common.Request;
import common.Response;
import common.ResponseCode;

public class ExitCommand implements Command {
    RequestSender requestSender;

    public ExitCommand(RequestSender requestSender) {
        this.requestSender = requestSender;
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "exit: завершить работу клиента";
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new IllegalArgumentException();
            }
            Request<String> request = new Request<>("exit", null);
            Response response = requestSender.sendRequest(request);
//            if (response.getResponseCode() == ResponseCode.OK) {
//                System.out.println(response.getResponseBody());
//            } else {
//                System.err.println(response.getResponseBody());
//            }
        } catch (IllegalArgumentException e) {
            System.out.println("Аргумент в данной команде не используется.");
        }
        System.exit(0);
    }
}
