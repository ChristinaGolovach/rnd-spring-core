package com.rnd.golovach;

public class ConsoleEventLogger implements IEventLogger {
    public void logEvent(String message) {
        System.out.println(message);
    }
}
