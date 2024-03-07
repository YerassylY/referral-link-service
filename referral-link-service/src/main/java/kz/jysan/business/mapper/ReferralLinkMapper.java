package kz.jysan.business.mapper;

import kz.jysan.business.entity.ReferralLink;
import kz.jysan.business.model.CreateReferralLinkRequest;

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
}