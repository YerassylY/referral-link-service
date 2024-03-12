package kz.jysan.business.controller;

import kz.jysan.business.api.ReferralLinkApi;
import kz.jysan.business.entity.ReferralLinkType;
import kz.jysan.business.model.CreateLinkTypeRequest;
import kz.jysan.business.model.CreateReferralLinkRequest;
import kz.jysan.business.model.ReferralLinkResponse;
import kz.jysan.business.service.ReferralLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ReferralLinkController implements ReferralLinkApi {
    private final ReferralLinkService service;

    @Override
    public ResponseEntity<Object> formReferralLink(CreateReferralLinkRequest referralLinkRequest) {
        ReferralLinkResponse response = service.formReferralLink(referralLinkRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<Object> getReferralLink(UUID id) {
        ReferralLinkResponse response = service.getReferralLink(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<Object> getReferralLinkTypes() {
        List<ReferralLinkType> referralLinkTypeList = service.getReferralLinkTypeList();
        return ResponseEntity.status(HttpStatus.OK).body(referralLinkTypeList);
    }

    @Override
    public ResponseEntity<Object> getReferralLinkType(String code) {
        ReferralLinkType referralLinkType = service.getReferralLinkType(code);
        return ResponseEntity.status(HttpStatus.OK).body(referralLinkType);
    }

    @Override
    public ResponseEntity<Object> addReferralLinkType(CreateLinkTypeRequest request) throws DataIntegrityViolationException {
        ReferralLinkType referralLinkType = service.addReferralLinkType(request);
        return ResponseEntity.status(HttpStatus.OK).body(referralLinkType);
    }

}
