package com.npotaves.CompanyApplication;

import com.npotaves.CompanyApplication.application.mapper.CompanyDtoMapper;
import com.npotaves.CompanyApplication.application.mapper.CompanyRequestMapper;
import com.npotaves.CompanyApplication.application.service.CompanyManagementService;
import com.npotaves.CompanyApplication.domain.model.Company;
import com.npotaves.CompanyApplication.domain.model.dto.CompanyDto;
import com.npotaves.CompanyApplication.domain.model.dto.request.CompanyRequest;
import com.npotaves.CompanyApplication.domain.port.CompanyPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
class CompanyManagementServiceTest {

    @InjectMocks
    private CompanyManagementService companyService;

    @Mock
    private CompanyPersistencePort companyPersistencePort;

    @Mock
    private CompanyRequestMapper companyRequestMapper;

    @Mock
    private CompanyDtoMapper companyDtoMapper;

    @Test
    void createNew_ShouldCreateCompanySuccessfully() {
        CompanyRequest request = new CompanyRequest();
        request.setCuit("22234567889");
        request.setCompanyName("Test Company");
        Company company = new Company(null, "22234567889", "Test Company", null, new ArrayList<>());
        Company savedCompany = new Company(1L, "22234567889", "Test Company", LocalDateTime.now(), new ArrayList<>());
        CompanyDto expectedDto = new CompanyDto(1L, "22234567889", "Test Company", savedCompany.getSubscriptionDate());

        when(companyRequestMapper.toDomain(request)).thenReturn(company);
        when(companyPersistencePort.create(any(Company.class))).thenReturn(savedCompany);
        when(companyDtoMapper.toDto(savedCompany)).thenReturn(expectedDto);
        CompanyDto result = companyService.createNew(request);
        assertNotNull(result);
        assertEquals(expectedDto.getIdCompany(), result.getIdCompany(), "El IdCompany no coincide");
        assertEquals(expectedDto.getCuit(), result.getCuit());
        assertEquals(expectedDto.getCompanyName(), result.getCompanyName());
        verify(companyPersistencePort, times(1)).create(company);
    }

    @Test
    void getSubscribedLastMonth_ShouldReturnListOfCompanies() {
        List<Company> companyList = List.of(new Company(1L, "22234567889", "Test Company", LocalDateTime.now(), new ArrayList<>()));
        List<CompanyDto> expectedDtoList = List.of(new CompanyDto(1L, "22234567889", "Test Company", LocalDateTime.now()));

        when(companyPersistencePort.getSubscribedLastMonth()).thenReturn(companyList);
        when(companyDtoMapper.toDto(any(Company.class))).thenReturn(expectedDtoList.get(0));
        List<CompanyDto> result = companyService.getSubscribedLastMonth();
        assertNotNull(result);
        assertEquals(expectedDtoList.size(), result.size());
        verify(companyPersistencePort, times(1)).getSubscribedLastMonth();
    }

    @Test
    void getTransactionLastMonth_ShouldReturnEmptyListIfNoCompanies() {
        when(companyPersistencePort.getTransactionLastMonth()).thenReturn(Collections.emptyList());
        List<CompanyDto> result = companyService.getTransactionLastMonth();
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(companyPersistencePort, times(1)).getTransactionLastMonth();
    }
}