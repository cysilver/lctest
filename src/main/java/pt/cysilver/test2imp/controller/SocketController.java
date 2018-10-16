package pt.cysilver.test2imp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import pt.cysilver.test2imp.pojo.Exchange;

@Controller
public class SocketController {

	@MessageMapping("/wsexchange")
	@SendTo("/topic/all")
	public String sendAll(Exchange oExchange) {
		System.err.println("ws:"+oExchange.toString());
		return oExchange.toString();
	}
}
