package com.spring.boot.rabbit.mq.springbootproducerconsumerrabbitmq;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.boot.rabbit.mq.springbootproducerconsumerrabbitmq.domain.SampleMessage;

public interface SampleMessageRepository extends MongoRepository<SampleMessage,String>{

}
