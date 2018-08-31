package com.sbt.sockets.homework.simplechat.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ClientThread extends Thread {

    private Socket socket;
    private Message message;
    private String login;
    private boolean flag = false;

    public ClientThread(Socket socket) {
        this.socket = socket;
        this.start();
    }

    @Override
    public void run() {
        try {
            final ObjectInputStream inputStream = new ObjectInputStream(this.socket.getInputStream());
            final ObjectOutputStream outputStream = new ObjectOutputStream(this.socket.getOutputStream());

            this.message = (Message) inputStream.readObject();
            this.login = this.message.getLogin();

            Server.getUserList().addUser(login, socket, outputStream, inputStream);


            this.message.setOnlineUsers(Server.getUserList().getUsers());


            while (true) {
                if (this.flag) {
                    this.flag = false;
                    break;
                }
                this.message = (Message) inputStream.readObject();
                if (!message.getMessage().equals(Config.HELLO_MESSAGE)) {
                    System.out.println("[" + login + "]: " + message.getMessage());
                }
            }
        } catch (SocketException e) {
            Server.getUserList().deleteUser(login);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
