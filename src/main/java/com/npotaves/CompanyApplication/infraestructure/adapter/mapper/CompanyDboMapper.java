package com.npotaves.CompanyApplication.infraestructure.adapter.mapper;

import com.npotaves.CompanyApplication.domain.model.Company;
import com.npotaves.CompanyApplication.infraestructure.adapter.entity.CompanyEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.osgi.service.component.annotations.Component;

@Mapper(componentModel = "spring", uses = TransactionDboMapper.class)
public interface CompanyDboMapper {
    @Mapping(source = "idCompany", target = "idCompany")
    @Mapping(source = "cuit", target = "cuit")
    @Mapping(source = "companyName", target = "companyName")
    @Mapping(source = "subscriptionDate", target = "subscriptionDate")
    @Mapping(source = "transactions", target = "transactions",ignore = true)
    CompanyEntity toDbo(Company domain);

    @InheritInverseConfiguration
    Company toDomain(CompanyEntity entity);
}
