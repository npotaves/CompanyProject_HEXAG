package com.npotaves.CompanyApplication;

import com.npotaves.CompanyApplication.domain.model.Company;
import com.npotaves.CompanyApplication.infraestructure.adapter.entity.CompanyEntity;
import com.npotaves.CompanyApplication.infraestructure.adapter.mapper.CompanyDboMapper;
import com.npotaves.CompanyApplication.infraestructure.adapter.mapper.CompanyDboMapperImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.time.LocalDateTime;


class CompanyDboMapperTest {

    @InjectMocks
    private CompanyDboMapper companyDboMapper = new CompanyDboMapperImpl();
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks
    }
    @Test
    public void shouldConvertToDbo() {
        Company company = new Company();
        company.setIdCompany(5L);
        company.setCuit("12345678");
        company.setCompanyName( "Test Company");
        company.setSubscriptionDate(LocalDateTime.now());

        CompanyEntity companyEntity = companyDboMapper.toDbo(company);
        assertNotNull(companyEntity);
        assertEquals(company.getIdCompany(), companyEntity.getIdCompany());
        assertEquals(company.getCuit(), companyEntity.getCuit());
        assertEquals(company.getCompanyName(), companyEntity.getCompanyName());
        assertTrue(company.getSubscriptionDate().isEqual(companyEntity.getSubscriptionDate()));
    }

    @Test
    public void shouldConvertToDomain() {
        // Arrange
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setIdCompany(1L);
        companyEntity.setCuit("12345678");
        companyEntity.setCompanyName( "Test Company");
        companyEntity.setSubscriptionDate(LocalDateTime.now());
        Company company = companyDboMapper.toDomain(companyEntity);

        assertNotNull(company);
        assertEquals(companyEntity.getIdCompany(), company.getIdCompany());
        assertEquals(companyEntity.getCuit(), company.getCuit());
        assertEquals(companyEntity.getCompanyName(), company.getCompanyName());
        assertTrue(companyEntity.getSubscriptionDate().isEqual(company.getSubscriptionDate()));
    }
}