package kz.jysan.business.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReferralLinkTypeResponse {
    private UUID id;
    private String code;
    private String name;
    private String urlBase;
    private Boolean actual;
    private String errorCode;
    private String errorMessage;
}
