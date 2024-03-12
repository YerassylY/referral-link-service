package kz.jysan.business.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("referral_link_type")
public class ReferralLinkType {
    @Id
    private String code;
    private String name;
    private String urlBase;
    private Boolean actual;
}


