package com.service.chataroundpush.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.service.chataround.dto.chat.ChatAroundDto;
import com.service.chataroundpush.server.PushDatastore;
import com.service.chataroundpush.service.PushService;

@Controller
public class ChatAroundPushMessageNew {
	private final static Logger LOGGER = Logger.getLogger(ChatAroundPushMessageNew.class
			.getName());
	
	@Autowired
	private PushService pushService;
	
	Gson gson = new Gson();
	
	@RequestMapping(value = "/sendChatMessage.do", method = { RequestMethod.POST})
	@ResponseBody
	public String chatAroundSendMessage(@RequestBody ChatMessageInternalDto chatMessageInternalDto, HttpServletResponse response) {
		LOGGER.fine("chatAroundSendMessage begin");
		chatMessageInternalDto = pushService.pushMessage(chatMessageInternalDto);
		//dto.setResponse("push.server.operation.sendmessage.ok");
		//dto = service.makePersistent(dto);
		//return gson.toJson(dto);
		return gson.toJson(chatMessageInternalDto);
	}
}
