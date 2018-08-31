package com.loggers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.text.DateFormat;

import static org.junit.Assert.*;

public class ConsoleEventLoggerImplTest {

    private static final String MESSAGE = "Test console logger";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setOutContent(){
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanStreams(){
        System.setOut(null);
    }

    @Test
    public void logEvent() {
        ConsoleEventLoggerImpl consoleEventLogger = new ConsoleEventLoggerImpl();
        Event event = new Event(new Date(),DateFormat.getDateInstance());
        event.setMsg(MESSAGE);

        consoleEventLogger.logEvent(event);

        assertTrue(outContent.toString().contains(event.toString()));

        assertEquals(event.toString().trim(),outContent.toString().trim());
    }
}