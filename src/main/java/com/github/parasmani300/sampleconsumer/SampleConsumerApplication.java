package com.github.parasmani300.sampleconsumer;

import com.github.parasmani300.sampleconsumer.config.KafkaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({KafkaConfig.class})
public class SampleConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleConsumerApplication.class, args);
	}

}
