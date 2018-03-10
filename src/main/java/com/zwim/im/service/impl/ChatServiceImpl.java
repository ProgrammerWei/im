package com.zwim.im.service.impl;

import com.zwim.im.service.ChatService;
import com.zwim.im.utils.RedisUtil;
import com.zwim.im.utils.WsPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

@Service("chatService")
public class ChatServiceImpl implements ChatService, MessageListener {
    @Autowired
    private StringRedisTemplate redisTemplate;
    RedisUtil RedisUtil;
    @Override
    public void say(String msg){
        redisTemplate.convertAndSend("chat", msg);
    }
    @Override
    public void onMessage(Message message, byte[] pattern) {
        RedisSerializer serializer = redisTemplate.getValueSerializer();
        String messageStr = serializer.deserialize(message.getBody()).toString();
        System.out.println("message received:" + messageStr);
    }
}
