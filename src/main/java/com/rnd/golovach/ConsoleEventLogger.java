package com.rnd.golovach;

public class ConsoleEventLogger implements IEventLogger {
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
