package kz.jysan.business.service;

import kz.jysan.business.entity.ReferralLink;
import kz.jysan.business.mapper.ReferralLinkMapper;
import kz.jysan.business.model.CreateReferralLinkRequest;
import kz.jysan.business.model.CreateReferralLinkResponse;
import kz.jysan.business.repository.ReferralLinkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReferralLinkService {
    private final ReferralLinkRepository repository;

    public CreateReferralLinkResponse formReferralLink(CreateReferralLinkRequest referralLinkRequest) {
        ReferralLink referralLink = ReferralLinkMapper.map(referralLinkRequest);
        referralLink.setLink(formLink(referralLink.getType(), referralLink.getTrackCode()));
        referralLink.setExpiredAt(LocalDateTime.now()); // TODO: write proper logic here

        saveReferralLinkEntity(referralLink);

        return CreateReferralLinkResponse.builder()
                .id(referralLink.getId())
                .link(referralLink.getLink())
                .expiredAt(referralLink.getExpiredAt())
                .build();
    }

    public void saveReferralLinkEntity(ReferralLink referralLink) {
        Optional.ofNullable(referralLink)
                .ifPresent(refLink -> repository.insert(
                        refLink.getId(),
                        refLink.getType(),
                        refLink.getTrackCode(),
                        refLink.getClient(),
                        refLink.getTtl(),
                        refLink.getActionLimit(),
                        refLink.getLink(),
                        refLink.getExpiredAt()
                ));
    }

    private String formLink(String requestType, String trackCode) {
        // TODO: write logic to form link
        return requestType + trackCode;
    }
}
