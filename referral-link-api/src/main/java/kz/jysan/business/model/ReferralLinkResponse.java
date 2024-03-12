package kz.jysan.business.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReferralLinkResponse {
    private UUID id;
    private String type;
    private String trackCode;
    private String client;
    private String ttl;
    private Integer actionLimit;
    private String link;
    private LocalDateTime expiredAt;
}
