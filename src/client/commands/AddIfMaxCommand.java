package client.commands;

import client.network.RequestSender;
import client.util.FlatRecorder;
import common.Request;
import common.Response;
import common.ResponseCode;
import data.Flat;

public class AddIfMaxCommand implements Command {
    RequestSender requestSender;
    FlatRecorder flatRecorder;

    public AddIfMaxCommand(RequestSender requestSender, FlatRecorder flatRecorder) {
        this.requestSender = requestSender;
        this.flatRecorder = flatRecorder;
    }

    @Override
    public String getName() {
        return "add_if_max";
    }

    @Override
    public String getDescription() {
        return "add_if_max: добавить новый элемент в коллекцию, если его значение превышает " +
                "значение наибольшего элемента этой коллекции";
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new IllegalArgumentException();
            }
            Flat flat = flatRecorder.recordFlat();
            Request<Flat> request = new Request<>("add_if_max", flat);
            Response response = requestSender.sendRequest(request);
            if (response.getResponseCode() == ResponseCode.OK) {
                System.out.println(response.getResponseBody());
            } else {
                System.err.println(response.getResponseBody());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Аргумент в данной команде не предусмотрен.");
        }
    }
}
