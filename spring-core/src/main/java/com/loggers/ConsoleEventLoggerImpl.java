package com.loggers;

public class ConsoleEventLoggerImpl implements EventLogger {
    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
