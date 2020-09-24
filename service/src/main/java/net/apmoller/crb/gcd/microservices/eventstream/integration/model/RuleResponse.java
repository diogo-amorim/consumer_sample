package net.apmoller.crb.gcd.microservices.eventstream.integration.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleResponse {
    private String complianceType;
    private String complianceLevel;
    private Boolean reportFrob;
    private Boolean reportEmptyContainers;
    private Boolean reportPreviousAndNext;
    private Boolean reportAtFirstPort;
    private Boolean countryCompliance;
}
