package com.rnd.golovach;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private  Client client;
    private IEventLogger eventLogger;

    public  void logEvent(Event event){
        String msg = event.getMessage().replaceAll(client.getId(),client.getFullName());
        event.setMessage(client.getGreeting() + " " + msg);
        eventLogger.logEvent(event);
    }

    public App (Client client, IEventLogger eventLogger){
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public  static  void main(String[] arg){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");

        Event event = (Event) context.getBean("event");
        event.setMessage("Call event for user 1");
        app.logEvent(event);

        Event event2 = (Event) context.getBean("event");
        event2.setMessage("Call event for user 2");
        app.logEvent(event2);

        Event event3 = (Event) context.getBean("event");
        event3.setMessage("Call event for user 3");
        app.logEvent(event3);



        context.close();

    }
}
