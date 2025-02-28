package com.npotaves.CompanyApplication.infraestructure.adapter;

import com.npotaves.CompanyApplication.domain.model.Company;
import com.npotaves.CompanyApplication.domain.port.CompanyPersistencePort;
import com.npotaves.CompanyApplication.infraestructure.adapter.entity.CompanyEntity;
import com.npotaves.CompanyApplication.infraestructure.adapter.mapper.CompanyDboMapper;
import com.npotaves.CompanyApplication.infraestructure.adapter.repository.CompanyRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompanySpringJpaAdapter implements CompanyPersistencePort {

    private final CompanyRepository companyRepository;
    private final CompanyDboMapper companyDboMapper;

    public CompanySpringJpaAdapter(CompanyRepository companyRepository, CompanyDboMapper companyDboMapper) {
        this.companyRepository = companyRepository;
        this.companyDboMapper = companyDboMapper;
    }

    @Override
    public Company create(Company company) {

        var companyToSave = companyDboMapper.toDbo(company);
        var companySaved = companyRepository.save(companyToSave);

        return companyDboMapper.toDomain(companySaved);
    }
    @Override
    public List<Company> getTransactionLastMonth() {

        LocalDateTime firstDayLastMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1).atStartOfDay();;
        LocalDateTime firstDayCurrentMonth = LocalDate.now().withDayOfMonth(1).atStartOfDay();;
        return companyRepository.findCompaniesWithTransfersLastMonth(firstDayLastMonth, firstDayCurrentMonth)
                .stream()
                .map(companyDboMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Company> getSubscribedLastMonth() {
        LocalDateTime firstDayLastMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1).atStartOfDay();;
        LocalDateTime firstDayCurrentMonth = LocalDate.now().withDayOfMonth(1).atStartOfDay();;

        return companyRepository.findCompaniesSubscribedLastMonth(firstDayLastMonth, firstDayCurrentMonth)
                .stream()
                .map(companyDboMapper::toDomain)
                .collect(Collectors.toList());
    }
}
