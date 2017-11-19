package com.rnd.golovach;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private  Client client;
    private IEventLogger eventLogger;

    public  void logEvent(String message){
        String msg = message.replaceAll(client.getId(),client.getFullName());
        eventLogger.logEvent(msg);
    }

    public App (Client client, IEventLogger eventLogger){
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public  static  void main(String[] arg){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        app.logEvent("Call event for user 1");

    }
}
