package kz.jysan.business.service;

import kz.jysan.business.entity.ReferralLinkEvent;
import kz.jysan.business.mapper.ReferralLinkMapper;
import kz.jysan.business.model.ReferralLinkEventRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static kz.jysan.business.config.ReferralLinkEventMQConfig.LinkClickEvent.REFERRAL_LINK_CLICK_QUEUE;
import static kz.jysan.business.config.ReferralLinkEventMQConfig.ProcessEndEvent.REFERRAL_LINK_PROCESS_END_QUEUE;
import static kz.jysan.business.config.ReferralLinkEventMQConfig.ProcessStartEvent.REFERRAL_LINK_PROCESS_START_QUEUE;

@Service
public class ReferralLinkListener {
    @Autowired
    private ReferralLinkService service;

    @RabbitListener(queues = REFERRAL_LINK_CLICK_QUEUE)
    public void receiveClickEvent(ReferralLinkEventRequest eventRequest) {
        ReferralLinkEvent event = ReferralLinkMapper.map(eventRequest);
        service.saveReferralLinkEvent(event);
        System.out.println("Received event: " + event);
        // Here you can store the event in your message queue or perform any other necessary operations
    }

    @RabbitListener(queues = REFERRAL_LINK_PROCESS_START_QUEUE)
    public void receiveProcessStartEvent(ReferralLinkEventRequest eventRequest) {
        ReferralLinkEvent event = ReferralLinkMapper.map(eventRequest);
        service.saveReferralLinkEvent(event);
        System.out.println("Received event: " + event);
        // Here you can store the event in your message queue or perform any other necessary operations
    }

    @RabbitListener(queues = REFERRAL_LINK_PROCESS_END_QUEUE)
    public void receiveProcessEndEvent(ReferralLinkEventRequest eventRequest) {
        ReferralLinkEvent event = ReferralLinkMapper.map(eventRequest);
        service.saveReferralLinkEvent(event);
        System.out.println("Received event: " + event);
        // Here you can store the event in your message queue or perform any other necessary operations
    }
}
