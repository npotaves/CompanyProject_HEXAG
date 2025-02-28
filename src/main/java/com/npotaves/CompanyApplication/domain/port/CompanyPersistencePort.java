package com.npotaves.CompanyApplication.domain.port;

import com.npotaves.CompanyApplication.domain.model.Company;

import java.util.List;

public interface CompanyPersistencePort {
    Company create(Company company);

    List<Company> getSubscribedLastMonth();

    List<Company> getTransactionLastMonth();

}
