package kz.jysan.business.mapper;

import kz.jysan.business.entity.ReferralLink;
import kz.jysan.business.entity.ReferralLinkEvent;
import kz.jysan.business.model.CreateReferralLinkRequest;
import kz.jysan.business.model.ReferralLinkEventRequest;
import kz.jysan.business.model.ReferralLinkResponse;

import java.util.Optional;
import java.util.UUID;


public class ReferralLinkMapper {

    public static ReferralLink map(CreateReferralLinkRequest referralLinkRequest) {
        return Optional.ofNullable(referralLinkRequest)
                .map(refLinkRequest -> ReferralLink.builder()
                        .id(UUID.randomUUID())
                        .type(referralLinkRequest.getType())
                        .trackCode(referralLinkRequest.getTrackCode())
                        .client(referralLinkRequest.getClient())
                        .ttl(referralLinkRequest.getTtl())
                        .actionLimit(referralLinkRequest.getActionLimit())
                        .build())
                .orElse(null);
    }

    public static ReferralLinkResponse map(ReferralLink referralLink) {
        return Optional.ofNullable(referralLink)
                .map(refLink -> ReferralLinkResponse.builder()
                        .id(refLink.getId())
                        .type(refLink.getType())
                        .trackCode(refLink.getTrackCode())
                        .client(refLink.getClient())
                        .ttl(refLink.getTtl())
                        .actionLimit(refLink.getActionLimit())
                        .link(refLink.getLink())
                        .expiredAt(refLink.getExpiredAt())
                        .build())
                .orElse(null);
    }

    public static ReferralLinkEvent map(ReferralLinkEventRequest request) {
        return Optional.ofNullable(request)
                .map(req -> ReferralLinkEvent.builder()
                        .id(UUID.randomUUID())
                        .event(req.getEvent())
                        .refCode(req.getRefCode())
                        .client(req.getClient())
                        .sibUserId(req.getSibUserId())
                        .actionType(req.getActionType())
                        .actionId(req.getActionId())
                        .result(req.getResult())
                        .build())
                .orElse(null);
    }

}