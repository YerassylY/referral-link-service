package kz.jysan.business.api;

import kz.jysan.business.model.CreateReferralLinkRequest;
import kz.jysan.business.model.CreateLinkTypeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;


public interface ReferralLinkApi {

    @PutMapping("/referral-link")
    ResponseEntity<Object> formReferralLink(CreateReferralLinkRequest referralLinkRequest);

    @GetMapping("/referral-link/{id}")
    ResponseEntity<Object> getReferralLink(@PathVariable("id") UUID id);

    @PutMapping("/referral-link/type")
    ResponseEntity<Object> addReferralLinkType(CreateLinkTypeRequest request);

    @GetMapping("/referral-link/types")
    ResponseEntity<Object> getReferralLinkTypes();

    @GetMapping("/referral-link/type/{code}")
    ResponseEntity<Object> getReferralLinkType(@PathVariable("code") String code);

    @PutMapping("/referral-link/type/{code}")
    ResponseEntity<Object> changeReferralLinkTypeState(@PathVariable("code") String code,
                                                       @RequestParam("actual") Boolean actual);

    @PutMapping("/referral-link/type/deactivate/{code}")
    ResponseEntity<Object> deactivateLinkType(@PathVariable("code") String code);


}
