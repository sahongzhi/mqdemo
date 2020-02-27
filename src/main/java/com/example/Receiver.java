package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @Author: SaHongzhi
 * @Date: 2020-02-26 12:26
 */

// 必须加此注解，该类才会被作为Message Driven POJO使用
@Component
@Slf4j
public class Receiver {
    ////多个queue消费者不会重复消费
    @JmsListener(destination = "mytest.queue", containerFactory = "jmsListener")
    public void receiveMsg(TextMessage msg) throws JMSException {
        System.out.println("线程:"+Thread.currentThread().getName()+" queue1 接收到的消息:" + msg);
        msg.acknowledge();
    }

    @JmsListener(destination = "mytest.queue", containerFactory = "jmsListener")
    public void receiveMsg2(TextMessage msg) throws JMSException {
        System.out.println("线程:"+Thread.currentThread().getName()+" queue2 接收到的消息:" + msg);
        msg.acknowledge();

    }

//    //多个topic消费者会重复消费
//    @JmsListener(destination = "mytest.topic", containerFactory = "topicListenerFactory")
//    public void receiveTopic(TextMessage msg) throws JMSException {
//        System.out.println("线程:"+Thread.currentThread().getName()+" topic1 接收到的消息:" + msg);
//        msg.acknowledge();
//
//    }
//
//    @JmsListener(destination = "mytest.topic", containerFactory = "topicListenerFactory")
//    public void receiveTopic2(TextMessage msg) throws JMSException {
//        System.out.println("线程:"+Thread.currentThread().getName()+" topic2 接收到的消息:" + msg);
//        msg.acknowledge();
//
//    }





}
