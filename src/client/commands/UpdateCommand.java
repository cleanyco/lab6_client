package client.commands;

import client.network.RequestSender;
import client.util.FlatRecorder;
import common.Request;
import common.Response;
import common.ResponseCode;
import data.Flat;

public class UpdateCommand implements Command {
    RequestSender requestSender;
    FlatRecorder flatRecorder;

    public UpdateCommand(RequestSender requestSender, FlatRecorder flatRecorder) {
        this.requestSender = requestSender;
        this.flatRecorder = flatRecorder;
    }

    @Override
    public String getDescription() {
        return "update: обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) {
                throw new IllegalArgumentException();
            }
            Flat flat = flatRecorder.recordFlat();
            Request<Flat> request = new Request<>("update", flat);
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
