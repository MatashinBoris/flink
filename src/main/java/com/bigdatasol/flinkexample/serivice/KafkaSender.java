package com.bigdatasol.flinkexample.serivice;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.bigdatasol.flinkexample.config.KafkaConfig.BETSLIP_PLACED_EVENT;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaSender {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void send(Object message) {
        log.info("send message:{}", message);
        String messageAsString;
        try {
            messageAsString = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException ex) {
            log.error("can't serialize message:{}", message, ex);
            throw new RuntimeException("can't send message:" + message, ex);
        }
        kafkaTemplate.send(BETSLIP_PLACED_EVENT, messageAsString);
    }
}
