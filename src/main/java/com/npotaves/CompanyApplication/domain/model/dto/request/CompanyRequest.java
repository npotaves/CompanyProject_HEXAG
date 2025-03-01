package com.npotaves.CompanyApplication.domain.model.dto.request;


import com.npotaves.CompanyApplication.domain.validation.ValidCuit;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyRequest {

    //@NotBlank(message = "El CUIT es obligatorio")
    //@Pattern(regexp = "^\\d{11}$", message = "El CUIT debe tener 11 dígitos numéricos")
    @ValidCuit
    private String cuit;
    @NotBlank(message = "La razón social es obligatoria")
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
