package com.npotaves.CompanyApplication;

import com.npotaves.CompanyApplication.domain.model.Company;
import com.npotaves.CompanyApplication.infraestructure.adapter.CompanySpringJpaAdapter;
import com.npotaves.CompanyApplication.infraestructure.adapter.entity.CompanyEntity;
import com.npotaves.CompanyApplication.infraestructure.adapter.mapper.CompanyDboMapper;
import com.npotaves.CompanyApplication.infraestructure.adapter.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.npotaves.CompanyApplication.domain.model.Company;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CompanySpringJpaAdapterTest {

    @InjectMocks
    private CompanySpringJpaAdapter companySpringJpaAdapter;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private CompanyDboMapper companyDboMapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateCompany() {
        Company company = new Company(1L, "12345678", "Test Company", LocalDateTime.now(), null);
        CompanyEntity companyEntity = new CompanyEntity(1L, "12345678", "Test Company", LocalDateTime.now(), null);
        CompanyEntity savedCompanyEntity = new CompanyEntity(1L, "12345678", "Test Company", LocalDateTime.now(), null);

        when(companyDboMapper.toDbo(company)).thenReturn(companyEntity);
        when(companyRepository.save(companyEntity)).thenReturn(savedCompanyEntity);
        when(companyDboMapper.toDomain(savedCompanyEntity)).thenReturn(company);

        Company result = companySpringJpaAdapter.create(company);

        assertEquals(company, result);
        verify(companyRepository).save(companyEntity);
        verify(companyDboMapper).toDbo(company);
        verify(companyDboMapper).toDomain(savedCompanyEntity);
    }
}