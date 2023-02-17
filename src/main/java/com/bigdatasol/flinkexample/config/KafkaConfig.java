package com.bigdatasol.flinkexample.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
@EnableKafka
@RequiredArgsConstructor
@Slf4j
public class KafkaConfig {

    public static final String BETSLIP_PLACED_EVENT = "Betslip_Placed_Event";

    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name(BETSLIP_PLACED_EVENT)
                .partitions(1)
                .replicas(1)
                .build();
    }
}