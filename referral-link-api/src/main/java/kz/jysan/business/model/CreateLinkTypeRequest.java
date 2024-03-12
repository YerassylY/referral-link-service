package kz.jysan.business.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateLinkTypeRequest {
    private String code;
    private String name;
    private String urlBase;
    private Boolean actual;
}

