package client.commands;

import client.network.RequestSender;
import client.util.FlatRecorder;
import common.Request;
import common.Response;
import common.ResponseCode;
import data.Flat;

public class AddIfMinCommand implements Command {
    RequestSender requestSender;
    FlatRecorder flatRecorder;

    public AddIfMinCommand(RequestSender requestSender, FlatRecorder flatRecorder) {
        this.requestSender = requestSender;
        this.flatRecorder = flatRecorder;
    }

    @Override
    public String getName() {
        return "add_if_min";
    }

    @Override
    public String getDescription() {
        return "add_if_min: добавить новый элемент в коллекцию, если его значение меньше, " +
                "чем у наименьшего элемента этой коллекции";
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new IllegalArgumentException();
            }
            Flat flat = flatRecorder.recordFlat();
            Request<Flat> request = new Request<>("add_if_min", flat);
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
