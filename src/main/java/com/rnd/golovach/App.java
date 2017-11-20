package com.rnd.golovach;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

public class App {
    private  Client client;
    private IEventLogger defaultLogger;
    private Map<EventType,IEventLogger> loggers;

    public  void logEvent(Event event, EventType type, String message){
        String msg  = message.replaceAll(client.getId(), client.getFullName());

        event.setMessage(client.getGreeting() + " " + msg);

        IEventLogger logger  = loggers.get(type);

        if (logger == null){
            logger = defaultLogger;
        }

        logger.logEvent(event);
    }

    public App (Client client, IEventLogger eventLogger, Map<EventType,IEventLogger> loggers){
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public  static  void main(String[] arg){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");

        Event event = (Event) context.getBean("event");

        app.logEvent(event,EventType.INFO,"Call event for user 1");
        app.logEvent(event,null,"Call event for user 1");
        app.logEvent(event,EventType.ERROR,"Call event for user 1");

        context.close();

    }
}
