package com.sbt.observer;

import com.sbt.observer.publisher.*;
import com.sbt.observer.listeners.*;
import com.sbt.observer.editor.*;

import java.net.URI;
import java.net.URL;


public class EditorExample {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener(URL.class.getClass().getResource("/log.txt")));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile(URL.class.getClass().getResource("/testFile.txt"));
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
