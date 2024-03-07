package kz.jysan.business.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("referral_link")
public class ReferralLink {
    @Id
    private UUID id;
    private String type;
    private String trackCode;
    private String client;
    private String ttl;
    private Integer actionLimit;
    private String link;
    private LocalDateTime expiredAt;
}
