package com.sbt.sockets.examples.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketThread extends Thread {

    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        boolean runner = true;
        while (runner) {
            try (
                   BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {
                System.out.println(String.format("connect accepted, client is %s , port is : %s", socket.getInetAddress(),
                        socket.getPort()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(String.format("Received line is %s", line));
                    if ("exit".equalsIgnoreCase(line)) {
                        socket.close();
                        runner = false;
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
