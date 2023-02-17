package com.bigdatasol.flinkexample;

import org.apache.flink.api.common.JobExecutionResult;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;

import java.util.Properties;


public class Flink {


    public static FlinkKafkaConsumer011<String> createStringConsumerForTopic( ) {

        String topic = "BETSLIP_PLACED_EVENT";
        String kafkaAddress = "localhost:9092";
        String kafkaGroup = "";

        Properties props = new Properties();
        props.setProperty("bootstrap.servers", kafkaAddress);
        props.setProperty("group.id",kafkaGroup);
        FlinkKafkaConsumer011<String> consumer = new FlinkKafkaConsumer011<>(topic, new SimpleStringSchema(), props);

        return consumer;
    }

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment environment = StreamExecutionEnvironment
               .createRemoteEnvironment("localhost", 8081, "C:\\Users\\Boris\\Desktop\\flink2\\flink-1.16.1\\bin");


        DataStream<String> stringInputStream = environment
                .addSource(createStringConsumerForTopic());

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

        JobExecutionResult execute = environment.execute();
    }
}
