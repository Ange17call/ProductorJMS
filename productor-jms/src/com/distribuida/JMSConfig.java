package com.distribuida;

import javax.jms.Destination;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@ComponentScan(basePackages = "com.distribuida")
public class JMSConfig {

	
	@Bean
	public ActiveMQConnectionFactory amqConnectionFactory(@Value("tcp://localhost:61616") String brokerUrl) {
		
		return new ActiveMQConnectionFactory(brokerUrl);
	}
	
	@Bean
    public CachingConnectionFactory connectionFactory(ActiveMQConnectionFactory connectionFactory){
		
        return new CachingConnectionFactory(connectionFactory);
    }

	@Bean
    public ActiveMQQueue defaultDestination(@Value("productor") String queueName){
		
        return new ActiveMQQueue(queueName);
    }
	
	@Bean
    public JmsTemplate jmsTemplate(CachingConnectionFactory connectionFactory, Destination defaultDestination){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setDefaultDestination(defaultDestination);
        return jmsTemplate;
    }
	


}
