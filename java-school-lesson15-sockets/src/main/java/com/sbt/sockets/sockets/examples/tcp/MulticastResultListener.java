package com.sbt.sockets.sockets.examples.tcp;


import com.sbt.sockets.sockets.examples.other.*;
import com.sbt.sockets.sockets.examples.other.StepListener;

import java.io.IOException;
import java.net.*;

public class MulticastResultListener implements StepListener {

    DatagramSocket socket;

    public MulticastResultListener() throws SocketException {
        socket = new DatagramSocket();
    }

    @Override
    public void stepPerformed(int stepNumber, String userCity, String aiCity) {
        String sendLine = String.format("Step %d userCity is %s Ai city is %s",
                stepNumber,
                userCity,
                aiCity);

        DatagramPacket packet = null;
        try {
            packet = new DatagramPacket(
                    sendLine.getBytes(),
                    sendLine.length(),
                    InetAddress.getByName("239.255.255.0"),
                    2019);

            socket.send(packet);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
