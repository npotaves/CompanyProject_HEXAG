package com.npotaves.CompanyApplication.application.mapper;

import com.npotaves.CompanyApplication.domain.model.Company;
import com.npotaves.CompanyApplication.domain.model.dto.request.CompanyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyRequestMapper {

    @Mapping(source = "companyName", target = "companyName")
    @Mapping(source = "cuit", target = "cuit")
    Company toDomain(CompanyRequest request);
}
