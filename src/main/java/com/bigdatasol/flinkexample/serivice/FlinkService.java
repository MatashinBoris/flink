package com.bigdatasol.flinkexample.serivice;

import com.bigdatasol.flinkexample.config.FlinkKafkaConsumerConfig;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FlinkService {

    private final FlinkKafkaConsumer011<String> flinkKafkaConsumer011;

    @PostConstruct
    @SneakyThrows
    public void handleKafkaMessages() {

        StreamExecutionEnvironment environment = StreamExecutionEnvironment
                .getExecutionEnvironment();

        DataStream<String> stringInputStream = environment
                .addSource(flinkKafkaConsumer011);

        /*FlinkKafkaProducer011<String> flinkKafkaProducer = createStringProducer(
                outputTopic, address);*/


        stringInputStream
                .map(e -> {
                    System.out.printf(e);
                    System.out.printf(e);
                    System.out.printf("   asdasdasda sadasdas sadasd");
                    return e.toLowerCase();
                })
                .print();

        environment.execute();
    }

}
