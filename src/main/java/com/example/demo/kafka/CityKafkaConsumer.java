package com.example.demo.kafka;

import com.example.demo.kafka.model.CityKafkaModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import static com.example.demo.config.StreamChannelsConfig.INPUT_CITY_DATA;

@Service
public class CityKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityKafkaConsumer.class);

//    @StreamListener(INPUT)
    @StreamListener(INPUT_CITY_DATA)
    public void consumeEmployeeDetails(CityKafkaModel cityKafkaModel) {
        LOGGER.info("I'm processing this guy: ", cityKafkaModel);
    }
}
