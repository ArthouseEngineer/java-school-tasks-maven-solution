package com.sbt.sockets.sockets.examples.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedHashSet;
import java.util.Set;

public  class ClientSocket {
    public static void main(String[] args) throws IOException {
        /*InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, 2018);

        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()))
        ) {
            bufferedWriter.newLine();
            bufferedWriter.flush();
            while (socket.isConnected()) {
                String line = bufferedReader.readLine();
                bufferedWriter.write((line));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }*/
       char ch = '0';
       while (ch <= 9) {
           System.out.println(ch++);
       }

    }
}
