//package com.example;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
//import org.springframework.jms.config.JmsListenerContainerFactory;
//
//import javax.jms.ConnectionFactory;
//
///**
// * @Author: SaHongzhi
// * @Date: 2020-02-26 14:28
// *
// * 下面的代码的作用是创建了两个JmsListenerContainerFactory，
// * 分别是topicListenerFactory和queueListenerFactory，
// * 其中topicListenerFactory创建的时候，将pubSubDomain设置成了true，
// * 表示该Listener负责处理Topic；queueListenerFactory创建的时候，
// * 将pubSubDomain设置成了false，也就是说，jms默认就是queue模式，
// * 该Listener主要负责处理Queue。
//
// */
//@Configuration
//@EnableJms
//public class JmsConfig {
//    @Bean
//    public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setPubSubDomain(true);
//        factory.setConnectionFactory(connectionFactory);
//        return factory;
//    }
//
//    @Bean
//    public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory connectionFactory) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setPubSubDomain(false);
//        factory.setConnectionFactory(connectionFactory);
//        return factory;
//    }
//}
