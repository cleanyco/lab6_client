package client;

import client.network.RequestSender;
import client.util.ClientConsole;

import java.util.Scanner;

public class Client {
    private final static String PS1 = "$ ";

    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);
        ClientConsole clientConsole = new ClientConsole();
        RequestSender requestSender = new RequestSender();
        String input;
        do {
            System.out.print(PS1);
            if (!userScanner.hasNextLine()) {
                return;
            } else {
                input = userScanner.nextLine();
                try {
                    clientConsole.parseCommand(input);
                } catch (IllegalArgumentException ex) {
//                    input = userScanner.nextLine();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("");
            }
        } while (!input.equals("exit"));
    }
}
