package kz.jysan.business.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReferralLinkEventRequest {
    private String event;
    private UUID refCode;
    private String client;
    private UUID sibUserId;
    private String actionType;
    private UUID actionId;
    private String result;
}
