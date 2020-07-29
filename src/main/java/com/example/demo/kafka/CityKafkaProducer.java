package com.example.demo.kafka;

import com.example.demo.kafka.model.CityKafkaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class CityKafkaProducer {

    @Autowired
    private Processor processor;

    public void producerCity(int id, String name) {

        // creating employee details
        CityKafkaModel city = new CityKafkaModel();
        city.setName(name);
        city.setId(id);


        Message<CityKafkaModel> message = MessageBuilder
                .withPayload(city)
                .build();

        processor.output()
                .send(message);
    }
}
