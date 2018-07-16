package com.sbt.observer.listeners;

import java.io.File;

public class EmailNotificationListener implements IEventListener {
    public String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println
                (
                        "Email to " + email + "Event type : " + eventType +
                                "operation with following file : " + file.getName()
                );
    }
}
