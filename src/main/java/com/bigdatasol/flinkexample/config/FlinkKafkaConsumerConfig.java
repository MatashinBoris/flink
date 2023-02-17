package com.bigdatasol.flinkexample.config;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class FlinkKafkaConsumerConfig {

    @Bean
    public FlinkKafkaConsumer011<String> createStringConsumerForTopic() {

        String topic = "BETSLIP_PLACED_EVENT";
        String kafkaAddress = "localhost:9092";
        String kafkaGroup = "./bin/flink";

        Properties props = new Properties();
        props.setProperty("bootstrap.servers", kafkaAddress);
        props.setProperty("group.id",kafkaGroup);
        FlinkKafkaConsumer011<String> consumer = new FlinkKafkaConsumer011<>(topic, new SimpleStringSchema(), props);

        return consumer;
    }

}
