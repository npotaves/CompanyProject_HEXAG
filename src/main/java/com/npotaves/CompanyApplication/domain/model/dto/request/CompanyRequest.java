package com.npotaves.CompanyApplication.domain.model.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyRequest {

    @NotBlank(message = "El CUIT es obligatorio")
    @NotEmpty(message = "El CUIT es obligatorio")
    @Pattern(regexp = "\\d{11}", message = "El CUIT debe tener 11 dígitos numéricos")
    private String cuit;
    @NotBlank(message = "La razón social es obligatoria")
    @NotEmpty(message = "La razón social es obligatoria")
    private String companyName;

    public String getCuit() {
        return cuit;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
