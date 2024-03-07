package kz.jysan.business.controller;

import kz.jysan.business.api.ReferralLinkApi;
import kz.jysan.business.model.CreateReferralLinkRequest;
import kz.jysan.business.model.CreateReferralLinkResponse;
import kz.jysan.business.service.ReferralLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReferralLinkController implements ReferralLinkApi {
    private final ReferralLinkService service;

    @Override
    public ResponseEntity<Object> formReferralLink(CreateReferralLinkRequest referralLinkRequest) {
        CreateReferralLinkResponse response;
        try {
            response = service.formReferralLink(referralLinkRequest);
            ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
