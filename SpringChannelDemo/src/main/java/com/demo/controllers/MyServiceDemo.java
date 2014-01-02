package com.demo.controllers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.message.GenericMessage;
import org.springframework.stereotype.Controller;

@Controller
public class MyServiceDemo {

 public static void main(String[] args) {
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
 
 }
}
