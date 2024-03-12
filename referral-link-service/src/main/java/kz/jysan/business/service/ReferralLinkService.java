package kz.jysan.business.service;

import kz.jysan.business.entity.ReferralLink;
import kz.jysan.business.entity.ReferralLinkType;
import kz.jysan.business.mapper.ReferralLinkMapper;
import kz.jysan.business.model.CreateLinkTypeRequest;
import kz.jysan.business.model.CreateReferralLinkRequest;
import kz.jysan.business.model.ReferralLinkResponse;
import kz.jysan.business.repository.ReferralLinkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReferralLinkService {
    private final ReferralLinkRepository repository;
    private final Environment environment;

    public ReferralLinkResponse formReferralLink(CreateReferralLinkRequest referralLinkRequest) {
        ReferralLink referralLink = ReferralLinkMapper.map(referralLinkRequest);
        setLink(referralLink);
        setExpireDate(referralLink);
        saveReferralLinkEntity(referralLink);
        return ReferralLinkResponse.builder()
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

    public String getSomeKey(String key){
        return environment.getProperty(key);
    }

    private void setLink(ReferralLink referralLink) {
         referralLink.setLink("https://ib.jusan.kz/dl/" + referralLink.getType() + "?refCode=" + referralLink.getId());
    }

    private void setExpireDate(ReferralLink link) {
        if (link.getTtl() == null)
            return;
        int days = Integer.parseInt(link.getTtl().substring(0, link.getTtl().length() - 1));
        link.setExpiredAt(LocalDateTime.now().plusDays(days));
    }

    public ReferralLinkResponse getReferralLink(UUID refId) {
        try {
            return ReferralLinkMapper.map(repository.getReferralLink(refId).get());
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException(getSomeKey("NOT_FOUND"));
        } catch (Exception ex) {
            throw new RuntimeException("Unexpected error occurred while adding referral link type: " + ex.getMessage(), ex);
        }
    }

    public List<ReferralLinkType> getReferralLinkTypeList() {
        return repository.getReferralLinkTypes();
    }

    public ResponseEntity<Object> getReferralLinkType(String code) {
        ReferralLinkType referralLinkType = repository.getReferralLinkType(code);
        if (referralLinkType == null) {
            throw new NoSuchElementException(getSomeKey("NOT_FOUND"));
        } else
            return ResponseEntity.status(HttpStatus.OK).body(referralLinkType);
    }

    public ReferralLinkType addReferralLinkType(CreateLinkTypeRequest request) {
        try {
            ReferralLinkType linkType = ReferralLinkType.builder()
                    .code(request.getCode())
                    .name(request.getName())
                    .urlBase(request.getUrlBase())
                    .actual(request.getActual())
                    .build();
            repository.addReferralLinkType(linkType.getCode(), linkType.getName(), linkType.getUrlBase(), linkType.getActual());
            return linkType;
        } catch (DuplicateKeyException ex) {
            // Log the exception or perform any necessary actions
            throw new DuplicateKeyException("CODE_ALREADY_EXISTS", ex);
        } catch (Exception ex) {
            // Log the exception or perform any necessary actions
            throw new RuntimeException("Unexpected error occurred while adding referral link type: " + ex.getMessage(), ex);
        }
    }

    public ResponseEntity<Object> changeReferralLinkTypeState(String code, Boolean actual) {
        repository.changeReferralLinkTypeState(code, actual);
        return getReferralLinkType(code);
    }

}
