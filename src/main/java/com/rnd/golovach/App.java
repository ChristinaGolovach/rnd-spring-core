package com.rnd.golovach;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private  Client client;
    private IEventLogger eventLogger;

    public  void logEvent(Event event){
        String msg = event.getMessage().replaceAll(client.getId(),client.getFullName());
        event.setMessage(msg);
        eventLogger.logEvent(event);
    }

    public App (Client client, IEventLogger eventLogger){
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public  static  void main(String[] arg){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        Event event = (Event) context.getBean("event");
        event.setMessage("Call event for user 1");
        app.logEvent(event);

    }
}
