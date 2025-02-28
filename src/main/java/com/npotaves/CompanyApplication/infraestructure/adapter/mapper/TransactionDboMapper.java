package com.npotaves.CompanyApplication.infraestructure.adapter.mapper;

import com.npotaves.CompanyApplication.domain.model.Company;
import com.npotaves.CompanyApplication.domain.model.Transaction;
import com.npotaves.CompanyApplication.infraestructure.adapter.entity.CompanyEntity;
import com.npotaves.CompanyApplication.infraestructure.adapter.entity.TransactionEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface TransactionDboMapper {
    @Mapping(source = "idTransaction", target = "idTransaction")
    @Mapping(source = "cuentaDebito", target = "cuentaDebito")
    @Mapping(source = "cuentaCredito", target = "cuentaCredito")
    @Mapping(source = "importe", target = "importe")
    @Mapping(source = "transactionDate", target = "transactionDate")
    TransactionEntity toDbo(Transaction domain);

    @InheritInverseConfiguration
    Transaction toDomain(TransactionEntity entity);
}
