package com.example.reviewms.review.kafkaConfig;

import com.example.commondtos.sharedDtos.ReviewEvent;
import com.example.reviewms.review.Review;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class ReviewsProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewsProducer.class);
    private NewTopic topic;
    private KafkaTemplate<String , ReviewEvent> kafkaTemplate;

    public ReviewsProducer(NewTopic topic, KafkaTemplate<String, ReviewEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Review review){
        ReviewEvent event = new ReviewEvent();
        event.setId(review.getId());
        event.setDescription(review.getDescription());
        event.setName(review.getName());
        event.setRating(review.getRating());
        event.setCompanyId(review.getCompanyId());

        Message<ReviewEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC , topic.name())
                .build();

        kafkaTemplate.send(message);
        LOGGER.info(String.format("Message Sent %s -> ",message));
    }
}
