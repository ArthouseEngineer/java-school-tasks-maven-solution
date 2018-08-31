package com.loggers;

public class ConsoleEventLoggerImpl implements EventLogger {
    @Override
    public void logEvent(String msg) {
        System.out.println(msg);
    }
}
