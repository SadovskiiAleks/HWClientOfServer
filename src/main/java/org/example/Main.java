package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8090;

        try (Socket clientSocket = new Socket(host,port);
            PrintWriter out = new
                    PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(clientSocket.getInputStream()))) {

            // Прочитал сообщение
            String resp = in.readLine();
            System.out.println(resp);
            //Отправил ответ на сообщение
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            out.println(name);

            while (true) {
                // Прочитал сообщение
                resp = in.readLine();
                System.out.println(resp);
                if (resp.equals("Are you child?")) {
                    String answer = scanner.nextLine();
                    out.println(answer);
                } else {
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}