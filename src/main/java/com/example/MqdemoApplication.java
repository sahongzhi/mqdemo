package com.example;

import com.alibaba.fastjson.JSONObject;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@SpringBootApplication
public class MqdemoApplication implements CommandLineRunner {

    @Autowired
    //注入springboot为我们配置好的JmsTemplate的bean
            JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        SpringApplication.run(MqdemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 1; i++) {
            final int j = i;
            Destination queue = new ActiveMQQueue("mytest.queue");
//            Destination topic = new ActiveMQTopic("mytest.topic");
//            jmsTemplate.send(topic,new MessageCreator() {
//                @Override
//                public Message createMessage(Session session) throws JMSException {
//                    JSONObject jsonObject = new JSONObject();
//                    jsonObject.put("name", "sasa");
//                    jsonObject.put("index", j);
//                    return session.createTextMessage(jsonObject.toJSONString());
//                }
//            });

            jmsTemplate.send(queue,  new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("name", "sasa");
                    jsonObject.put("index", j);
                    return session.createTextMessage(jsonObject.toJSONString());
                }
            });

        }

    }

//    @Override
//    public void run(String... args) throws Exception {
//        for (int i = 0; i < 1; i++) {
//            final int j = i;
//            Destination queue = new ActiveMQQueue("mytest.async.queue");
//            jmsTemplate.send(queue, new MessageCreator() {
//                @Override
//                public Message createMessage(Session session) throws JMSException {
//                    JSONObject jsonObject = new JSONObject();
//                    jsonObject.put("name", "sasa");
//                    jsonObject.put("index", j);
//                    return session.createTextMessage(jsonObject.toJSONString());
//                }
//            });
//        }
//    }
}
