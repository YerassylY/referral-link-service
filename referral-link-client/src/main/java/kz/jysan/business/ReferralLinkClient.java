package kz.jysan.business;

import kz.jysan.business.api.ReferralLinkApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "referral-link", url = "${referral-link.service.url}")
public interface ReferralLinkClient extends ReferralLinkApi {
}
