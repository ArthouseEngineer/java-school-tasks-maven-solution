package com;

import com.Entity.Client;
import com.loggers.ConsoleEventLoggerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client client;
    ConsoleEventLoggerImpl logger;

    public App(Client client, ConsoleEventLoggerImpl logger) {
        this.client = client;
        this.logger = logger;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) applicationContext.getBean("app");

        app.logEvent("Some event for user 1");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        logger.logEvent(message);
    }
}
