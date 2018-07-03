package com.sbt.sockets.examples.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketExample {

    public static final int PORT = 2018;

    public static void main(String[] args) throws IOException {


      ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println(String.format("Application started, and listening port : %d",PORT));
        System.out.println("Wait connect...");
        ExecutorService pool = Executors.newFixedThreadPool(2);
        while (true) {
            pool.execute(new InTownGameSocketThread(serverSocket.accept()));
        }
    }
}
