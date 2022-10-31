package com.github.parasmani300.sampleconsumer.consumer;

import com.github.parasmani300.sampleconsumer.avro.SampleClass;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "sample-producer",groupId = "sales-101",containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String,SampleClass> message) {
        try {
////            SampleClass sampleClass =  message.value();
//            System.out.println("Recieved messsae in group" + message.key().getClass());
//            System.out.println(message.value().getClass());
            System.out.println(message.value());
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
