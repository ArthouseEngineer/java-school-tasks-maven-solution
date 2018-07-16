package com.sbt.observer.listeners;

import java.io.File;
import java.net.URI;
import java.net.URL;

public class LogOpenListener implements IEventListener {
    private File log;

    public LogOpenListener(URL fileName) {
        this.log = new File(fileName.toString());
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println
                (
                        "Save to log " + log + " operation type : " + eventType +
                        " operation with the following file : " + file.getName()
                );
    }
}
