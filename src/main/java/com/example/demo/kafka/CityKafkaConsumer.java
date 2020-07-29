package com.example.demo.kafka;

import com.example.demo.kafka.model.CityKafkaModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import static org.springframework.cloud.stream.messaging.Sink.INPUT;

@Service
public class CityKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityKafkaConsumer.class);

    @StreamListener("kakaka")
    public void consumeEmployeeDetails(CityKafkaModel cityKafkaModel) {
        LOGGER.info("I'm processing this guy: ", cityKafkaModel);
    }
}
