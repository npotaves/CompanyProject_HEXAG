package com.npotaves.CompanyApplication.application.service;

import com.npotaves.CompanyApplication.application.mapper.CompanyDtoMapper;
import com.npotaves.CompanyApplication.application.mapper.CompanyRequestMapper;
import com.npotaves.CompanyApplication.application.usecases.CompanyService;
import com.npotaves.CompanyApplication.domain.model.dto.CompanyDto;
import com.npotaves.CompanyApplication.domain.model.dto.request.CompanyRequest;
import com.npotaves.CompanyApplication.domain.port.CompanyPersistencePort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CompanyManagementService implements CompanyService {

    private final CompanyPersistencePort companyPersistencePort;
    private final CompanyRequestMapper companyRequestMapper;
    private final CompanyDtoMapper companyDtoMapper;


    @Autowired
    public CompanyManagementService(final CompanyPersistencePort companyPersistencePort,
                                 final CompanyRequestMapper companyRequestMapper,
                                 final CompanyDtoMapper companyDtoMapper){
        this.companyPersistencePort = companyPersistencePort;
        this.companyRequestMapper = companyRequestMapper;
        this.companyDtoMapper = companyDtoMapper;
    }

    @Override
    public CompanyDto createNew(CompanyRequest request) {
        var companyRequest = companyRequestMapper.toDomain(request);
        companyRequest.setSubscriptionDate(LocalDateTime.now());
        var companyCreated = companyPersistencePort.create(companyRequest);
        return companyDtoMapper.toDto(companyCreated);
    }

    @Override
    public List<CompanyDto> getSubscribedLastMonth() {
        var companies = companyPersistencePort.getSubscribedLastMonth();
       return companies
                .stream()
                .map(companyDtoMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<CompanyDto> getTransactionLastMonth() {
        var companies = companyPersistencePort.getTransactionLastMonth();
        return companies
                .stream()
                .map(companyDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
