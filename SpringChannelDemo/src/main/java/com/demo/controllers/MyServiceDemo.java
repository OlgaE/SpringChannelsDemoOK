package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.message.GenericMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MyServiceDemo {

 /*@Autowired
 @Qualifier
 private MessageChannel inputChannel;
 
 @Autowired
 @Qualifier
 private PollableChannel outputChannel;*/
	
 @RequestMapping(value = "/to-channels-page.htm", method = RequestMethod.GET)
 public static void main(String[] atgs) {
  
  AbstractApplicationContext context = new ClassPathXmlApplicationContext("service.xml", MyServiceDemo.class);

  MessageChannel inputChannel =  context.getBean("inputChannel", MessageChannel.class);
  PollableChannel outputChannel =  context.getBean("outputChannel", PollableChannel.class);

// Just senging messages into message channel.
  for(int i=0;i<10;i++){
     inputChannel.send(new GenericMessage<String>("World : "+(i+1)));
  }
 
  // Getting message from message channel
  System.out.println("==> Returning from MyService : " + outputChannel.receive(0).getPayload());
  System.out.println("==> Returning from MyService : " + outputChannel.receive(0).getPayload());
  System.out.println("==> Returning from MyService : " + outputChannel.receive(0).getPayload());
  System.out.println("==> Returning from MyService : " + outputChannel.receive(0).getPayload());
  System.out.println("==> Returning from MyService : " + outputChannel.receive(0).getPayload());
 
  //return "channels";
 }
}
