package com.spring.boot.rabbit.mq.springbootproducerconsumerrabbitmq;

import java.util.logging.Logger;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.rabbit.mq.springbootproducerconsumerrabbitmq.domain.SampleMessage;

@RestController
public class SampleMessageProducer {
	private static final Logger LOGGER = Logger.getLogger(SampleMessageProducer.class.getName());


	private final RabbitTemplate rabbitTemplate;
	@Autowired
	private SampleMessageRepository sampleMessageRepository;

	public SampleMessageProducer(ConnectionFactory connectionFactory) {
		this.rabbitTemplate = new RabbitTemplate(connectionFactory);
	}

	public void sendMessage(SampleMessage sampleMessage) {
		rabbitTemplate.convertAndSend("SampleRabbitMQQueue", sampleMessage.toString());
	}

	@PostMapping("/produce")
	public ResponseEntity<SampleMessage> produceSamplMessage(@RequestBody SampleMessage sampleMessage) {
		sendMessage(sampleMessage);
		LOGGER.info("Message received"+ sampleMessage.toString());
		sampleMessageRepository.save(sampleMessage);
		return ResponseEntity.ok(sampleMessage);
	}

}
