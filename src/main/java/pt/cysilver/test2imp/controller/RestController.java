package pt.cysilver.test2imp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pt.cysilver.test2imp.pojo.Exchange;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jms.queue.name}")
	private String queueName;
	
	@PostMapping(path="/exchange")
	public Exchange newExchangeRequest(@RequestBody Exchange newExchage) {
		System.err.println(queueName);
        jmsTemplate.convertAndSend(queueName, newExchage);
        return newExchage;
	}
	
	@GetMapping("/exchange")
	public Exchange getExchange() {
		return new Exchange();
	}
	
}
