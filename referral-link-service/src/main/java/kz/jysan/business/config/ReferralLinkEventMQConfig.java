package kz.jysan.business.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReferralLinkEventMQConfig {

    // event-referral-link-click-actions
    public static class LinkClickEvent {
        public static final String REFERRAL_LINK_CLICK_EXCHANGE = "referral-link-click-x";
        public static final String REFERRAL_LINK_CLICK_QUEUE = "referral-link-click-q";
        public static final String REFERRAL_LINK_CLICK_ROUTING_KEY = REFERRAL_LINK_CLICK_QUEUE;

        @Bean
        TopicExchange eventClickExchange() {
            return new TopicExchange(REFERRAL_LINK_CLICK_EXCHANGE);
        }

        @Bean
        Queue eventClickQueue() {
            return new Queue(REFERRAL_LINK_CLICK_QUEUE, true);
        }

        @Bean
        Binding eventClickBinding(Queue eventClickQueue, TopicExchange eventClickExchange) {
            return BindingBuilder.bind(eventClickQueue).to(eventClickExchange).with(REFERRAL_LINK_CLICK_ROUTING_KEY);
        }
    }

    // event-referral-link-process-start-actions
    public static class ProcessStartEvent {
        public static final String REFERRAL_LINK_PROCESS_START_EXCHANGE = "referral-link-process-start-x";
        public static final String REFERRAL_LINK_PROCESS_START_QUEUE = "referral-link-process-start-q";
        public static final String REFERRAL_LINK_PROCESS_START_KEY = REFERRAL_LINK_PROCESS_START_QUEUE;

        @Bean
        TopicExchange eventProcessStartExchange() {
            return new TopicExchange(REFERRAL_LINK_PROCESS_START_EXCHANGE);
        }

        @Bean
        Queue eventProcessStartQueue() {
            return new Queue(REFERRAL_LINK_PROCESS_START_QUEUE);
        }

        @Bean
        Binding eventProcessStartBinding(Queue eventProcessStartQueue, TopicExchange eventProcessStartExchange) {
            return BindingBuilder.bind(eventProcessStartQueue).to(eventProcessStartExchange).with(REFERRAL_LINK_PROCESS_START_KEY);
        }
    }

    // Очередь событий о статусе выполнения действия по ссылке : event-referral-link-process-end-actions
    public static class ProcessEndEvent {
        public static final String REFERRAL_LINK_PROCESS_END_EXCHANGE = "referral-link-process-end-x";
        public static final String REFERRAL_LINK_PROCESS_END_QUEUE = "referral-link-process-end-q";
        public static final String REFERRAL_LINK_PROCESS_END_KEY = REFERRAL_LINK_PROCESS_END_QUEUE;

        @Bean
        TopicExchange eventProcessEndExchange() {
            return new TopicExchange(REFERRAL_LINK_PROCESS_END_EXCHANGE);
        }

        @Bean
        Queue eventProcessEndQueue() {
            return new Queue(REFERRAL_LINK_PROCESS_END_QUEUE);
        }

        @Bean
        Binding eventProcessEndBinding(Queue eventProcessEndQueue, TopicExchange eventProcessEndExchange) {
            return BindingBuilder.bind(eventProcessEndQueue).to(eventProcessEndExchange).with(REFERRAL_LINK_PROCESS_END_KEY);
        }
    }

}
