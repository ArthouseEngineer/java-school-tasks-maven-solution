package com.sbt.sockets.homework.simplechat.server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String PROPERTIES_FILE = "server.properties";

    public static int PORT;
    public static int HISTORY_LENGTH;
    public static String HELLO_MESSAGE;

    static {
        Properties properties = new Properties();
        InputStream propertiesFile;

        try {
            propertiesFile = Config.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
            properties.load(propertiesFile);

            PORT = Integer.parseInt(properties.getProperty("PORT"));
            HISTORY_LENGTH = Integer.parseInt(properties.getProperty("HISTORY_LENGTH"));
            HELLO_MESSAGE = properties.getProperty("HELLO_MESSAGE");

        } catch (FileNotFoundException e) {
            System.err.println("Properties file not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error while reading file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(PORT);
    }
}
