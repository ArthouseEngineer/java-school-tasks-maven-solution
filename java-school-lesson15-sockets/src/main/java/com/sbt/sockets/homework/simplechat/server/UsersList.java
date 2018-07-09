package com.sbt.sockets.homework.simplechat.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.sbt.sockets.homework.simplechat.client.*;

public class UsersList {
    private Map<String, Client> onlineUsers = new ConcurrentHashMap<>();

    public boolean addUser(String login, Socket socket, ObjectOutputStream oos, ObjectInputStream ois) {
        if (!this.onlineUsers.containsKey(login)) {
            this.onlineUsers.put(login, new Client(socket, oos, ois));
            return false;
        } else {
            int i = 1;
            while (this.onlineUsers.containsKey(login)) {
                login = login + i;
                i++;
            }
            this.onlineUsers.put(login, new Client(socket, oos, ois));
        }
        return true;
    }

    public void deleteUser(String login) {
        this.onlineUsers.remove(login);
        System.out.println("User name : " + login + " leave from this chat room!");
    }

    public String[] getUsers() {
        return this.onlineUsers.keySet().toArray(new String[0]);
    }

    public ArrayList<Client> getClientsList() {
        ArrayList<Client> clientsList = new ArrayList<Client>(this.onlineUsers.entrySet().size());

        String s = "";
        for (Map.Entry<String, Client> m : this.onlineUsers.entrySet()) {
            clientsList.add(m.getValue());
            System.out.println(m.getKey());
            s = s + m.getKey();
        }
        return clientsList;
    }
}
