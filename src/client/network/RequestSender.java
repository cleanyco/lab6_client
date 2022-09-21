package client.network;

import common.Request;
import common.Response;
import common.ResponseCode;

import java.io.*;
import java.net.Socket;

public class RequestSender {
    private final int PORT = 8888;
    private final int MAX_ATTEMPTS = 2;
    int connectionAttempts = 0;

    public Response sendRequest(Request<?> request) {


        if (request == null) {
            throw new IllegalArgumentException("Запрос не может быть пустым.");
        }

        OutputStream os;
        InputStream is;
        try {
            System.out.println("Ожидаем подключение к серверу...");
            Socket clientSocket = new Socket("localhost", PORT);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(request);
            oos.flush();
            byte[] byteRequest = bos.toByteArray();
            os = clientSocket.getOutputStream();
            os.write(byteRequest);
            os.flush();
            System.out.println("Отпрвляем запрос...");

            is = clientSocket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            return (Response) ois.readObject();
            //FIXME обработать ClassNotFoundException
            //FIXME посмотреть документацию на наличие выбрасываемых exception'ов
            //FIXME придумать, как закрыть потоки ois и oos
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Неудачная попытка подключения к серверу!\n" +
                    "Попробуем еще раз...");
            connectionAttempts++;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException exception) {
                //исключение проглочено
            }
            if (connectionAttempts == MAX_ATTEMPTS) {
                System.out.println("Попытки повторного подключения не увенчались успехом!");
                System.out.println("Завершение работы...");
                System.exit(-1);
            } else {
                sendRequest(request);
            }
        }
        //FIXME
        return new Response(ResponseCode.ERROR, "Не удалось подключиться к серверу.");
    }
}
