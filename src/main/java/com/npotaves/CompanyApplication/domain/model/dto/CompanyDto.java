package com.npotaves.CompanyApplication.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyDto {

    @JsonProperty("idCompany")
    private Long idCompany;

    @JsonProperty("cuit")
    private String cuit;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("subscriptionDate")
    private LocalDateTime subscriptionDate;

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
