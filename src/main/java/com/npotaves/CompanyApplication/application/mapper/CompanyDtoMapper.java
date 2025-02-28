package com.npotaves.CompanyApplication.application.mapper;

import com.npotaves.CompanyApplication.domain.model.Company;
import com.npotaves.CompanyApplication.domain.model.dto.CompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyDtoMapper {
    @Mapping(source = "idCompany", target = "idCompany")
    @Mapping(source = "companyName", target = "companyName")
    @Mapping(source = "cuit", target = "cuit")
    @Mapping(source = "subscriptionDate", target = "subscriptionDate")
    CompanyDto toDto(Company domain);
}
