package com.zwim.im.controller;

import com.zwim.im.service.ChatService;
import com.zwim.im.utils.WsPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ChatController {
    @Autowired
    private ChatService chatService;
    @ResponseBody
    @RequestMapping("/sendWs")
    public String sendWs(String message) {
        chatService.say(message);
        return message;
    }
}
