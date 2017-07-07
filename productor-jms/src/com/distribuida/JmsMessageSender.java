package com.distribuida;
  

//import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;


  
@Component
public class JmsMessageSender {
  
  @Autowired
  private JmsTemplate jmsTemplate;
    
  public void send(final String text) {
		
		
		this.jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage(text);
				message.setJMSReplyTo(new ActiveMQQueue("productor"));
				return message;
			}
		});

	}
  /*public void send(final Destination dest, final String text) {
		
		
		this.jmsTemplate.send(dest, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage(text);
				return message;
			}
		});
  
	}*/

}
