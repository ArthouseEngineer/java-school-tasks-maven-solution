package com;

import com.Entity.Client;
import com.loggers.Event;
import com.loggers.EventLogger;
import com.loggers.EventType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {

    private EventLogger defaultEventLogger;
    private Map<EventType, EventLogger> loggersMap;

    private Client client;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        App app = applicationContext.getBean(App.class);

        Event event = applicationContext.getBean(Event.class);

        app.logEvent(EventType.INFO,event, "some event for user 1");

        app.logEvent(EventType.ERROR,event,"some event for user 2");
    }

    public App(EventLogger defaultEventLogger, Map<EventType, EventLogger> loggersMap, Client client) {
        super();
        this.defaultEventLogger = defaultEventLogger;
        this.loggersMap = loggersMap;
        this.client = client;
    }

    private void logEvent(EventType eventType, Event event, String msg) {
        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggersMap.get(eventType);
        if (logger == null) {
            logger = defaultEventLogger;
        }
        logger.logEvent(event);
    }

}
