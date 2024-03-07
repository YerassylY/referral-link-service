package kz.jysan.business.api;

import kz.jysan.business.model.CreateReferralLinkRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;


public interface ReferralLinkApi {

    @PutMapping("/referral-link")
    ResponseEntity<Object> formReferralLink(CreateReferralLinkRequest referralLinkRequest);

}
