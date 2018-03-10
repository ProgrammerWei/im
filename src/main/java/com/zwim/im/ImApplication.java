package com.zwim.im;

import com.zwim.im.utils.WsServer;
import org.java_websocket.WebSocketImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class ImApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ImApplication.class, args);
		/**
		 * 启动即时聊天服务
		 */

			WebSocketImpl.DEBUG = false;
			WsServer s;
			s = new WsServer(8887);
			s.start();

//		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
//		CountDownLatch latch = ctx.getBean(CountDownLatch.class);
//		template.convertAndSend("chat", "Hello from Redis!");
//		try {
//			latch.await();
//		}catch (Exception e){
//			e.printStackTrace();;
//		}
//
//		System.exit(0);
	}
}
