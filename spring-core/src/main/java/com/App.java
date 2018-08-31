package com;

import com.Entity.Client;
import com.loggers.Event;
import com.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private EventLogger eventLogger;
    private Client client;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = applicationContext.getBean(App.class);

        Event event = applicationContext.getBean(Event.class);
        app.logEvent(event,"some event for user 1");

        applicationContext.close();

    }

    public App(Client client, EventLogger eventLogger) {
        super();
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(Event event, String msg) {
        String message = msg.replaceAll(String.valueOf(client.getId()),client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

}
