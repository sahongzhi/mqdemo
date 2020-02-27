package com.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * @Author: SaHongzhi
 * @Date: 2020-02-26 12:25
 */
public class Msg implements MessageCreator {
    @Override
    public Message createMessage(Session session) throws JMSException {
        //return session.createTextMessage("这是测试消息");

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","sasa");
        return session.createTextMessage(jsonObject.toJSONString());
    }
}