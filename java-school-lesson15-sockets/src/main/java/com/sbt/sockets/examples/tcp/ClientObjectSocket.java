package com.sbt.sockets.examples.tcp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientObjectSocket {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, 2018);
        try (
                ObjectOutputStream ois = new ObjectOutputStream(socket.getOutputStream())
        ) {
            ois.writeObject(new TestClass("Привет мир!!!"));
            ois.flush();
        }
    }
}
