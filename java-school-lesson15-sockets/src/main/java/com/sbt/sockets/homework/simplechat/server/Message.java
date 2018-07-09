package com.sbt.sockets.homework.simplechat.server;

import java.io.Serializable;
import java.util.Date;


public class Message implements Serializable {

    private String login;
    private String message;
    private String[] users;
    private Date time;

    /** Клиентский конструктор
     * @param login
     * @param message
     */
    public Message(String login, String message) {
        this.login = login;
        this.message = message;
        this.time = java.util.Calendar.getInstance().getTime();
    }


    public void setOnlineUsers(String[] users) {
        this.users = users;
    }

    public String getLogin() {
        return login;
    }

    public String getMessage() {
        return message;
    }

}
