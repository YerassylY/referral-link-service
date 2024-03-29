package kz.jysan.business.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReferralLinkRequest {
    private String type;
    private String trackCode;
    private String client;
    private String ttl;
    private Integer actionLimit;
}

