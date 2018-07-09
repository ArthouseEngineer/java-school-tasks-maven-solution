package com.sbt.sockets.sockets.examples.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ObjectSocketThread implements Runnable {

    private Socket socket;

    public ObjectSocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            while (socket.isConnected()) {
                TestClass object = (TestClass) objectInputStream.readObject();
                System.out.println(object.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
