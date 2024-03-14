package kz.jysan.business.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReferralLinkEvent {
    @Id
    private UUID id;
    private String event;
    private UUID refCode;
    private String client;
    private UUID sibUserId;
    private String actionType;
    private UUID actionId;
    private String result;
}
