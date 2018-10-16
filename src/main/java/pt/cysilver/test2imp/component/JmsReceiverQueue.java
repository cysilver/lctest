package pt.cysilver.test2imp.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import pt.cysilver.test2imp.pojo.Exchange;

@Component
public class JmsReceiverQueue {
	
	@Autowired
	private SimpMessagingTemplate brokerMessagingTemplate;
	
	@JmsListener(destination="${jms.queue.name}", containerFactory = "myFactory")
	public void receiveRequest(Exchange oExchange) {
		System.err.println(oExchange.toString());
        brokerMessagingTemplate.convertAndSend("/topic/all", oExchange.toString());
	}
}
