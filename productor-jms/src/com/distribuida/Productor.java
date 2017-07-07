package com.distribuida;
 

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 
 
public class Productor {
 
  public static void main(String[] args) {
    
    ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
	//ApplicationContext ctx = new AnnotationConfigApplicationContext(JMSConfig.class);   
    
    JmsMessageSender mensaje = (JmsMessageSender) ctx.getBean("jmsMessageSender");
         
    mensaje.send("hola mundo");
         
    
   // ((AnnotationConfigApplicationContext)ctx).close();
    ((ClassPathXmlApplicationContext)ctx).close();
  }
 
}