package com.sbt.sockets.homework.simplechat.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import com.sbt.sockets.homework.simplechat.server.*;

public class SocketClient {
    private final static String address = "127.0.0.1";
    private final static int serverPort = 2020;

    private static String userName = "";
    static Socket socket = null;

    public static void main(String[] args) {

        System.out.println("Hello Stranger!\n");
        System.out.println("Tell me who you are and press  Enter please! \n");

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        try {
            userName = keyboard.readLine();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            socket = new Socket(ipAddress, serverPort);

            OutputStream outputStream = socket.getOutputStream();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);


            String message;
            System.out.println("Enter you message and press Enter \n");


            while (true) {
                message = keyboard.readLine();
                objectOutputStream.writeObject(new Message(userName, message));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

