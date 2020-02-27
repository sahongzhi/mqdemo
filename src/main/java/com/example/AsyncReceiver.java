package com.example;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @Author: SaHongzhi
 * @Date: 2020-02-26 12:26
 * <p>
 * 异步测试
 */

// 必须加此注解，该类才会被作为Message Driven POJO使用
@Component
public class AsyncReceiver {
    @JmsListener(destination = "mytest.async.queue",containerFactory = "jmsListener")
    public void receiveMsg(TextMessage msg) throws JMSException {
        System.out.println("线程:"+Thread.currentThread().getName()+" queue 接收到的消息:" + msg);
//        try {
            msg.acknowledge(); // 客户端手动消息确认机制，如果我们的程序处理正常时，需手动调用
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }

    }


    //必须抛出异常才能重试，不能try catch
//    @JmsListener(destination = "mytest.async.queue")
//    public void receiveErrorMsg(TextMessage msg) throws Exception {
//        System.out.println("线程:" + Thread.currentThread().getName() + " queue 接收到的消息:" + msg);
//        throw new Exception();
//
//    }

}
