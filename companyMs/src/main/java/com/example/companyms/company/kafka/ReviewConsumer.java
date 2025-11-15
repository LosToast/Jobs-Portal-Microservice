package com.example.companyms.company.kafka;

import com.example.commondtos.sharedDtos.ReviewEvent;
import com.example.companyms.company.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ReviewConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewConsumer.class);
    private CompanyService companyService;

    public ReviewConsumer(CompanyService companyService) {
        this.companyService = companyService;
    }


    @KafkaListener(topics = "${spring.kafka.topic.name}" ,groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ReviewEvent event){
        LOGGER.info(String.format("Consumed Review %s" ,event));

        companyService.updateCompanyRating(event);
    }

}
