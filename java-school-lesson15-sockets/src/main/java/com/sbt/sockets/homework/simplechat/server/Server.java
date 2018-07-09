package com.sbt.sockets.homework.simplechat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {

    private static UsersList list = new UsersList();


    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(Config.PORT);

            while (true) {
                Socket client = null;
                while (client == null) {
                    client = serverSocket.accept();
                }
                new ClientThread(client);
            }
        } catch (SocketException e) {
            System.err.println("Socket exception!");
        } catch (IOException e) {
            System.err.println("I/O exception!");
        }
    }

    public synchronized static UsersList getUserList() {
        return list;
    }

}
