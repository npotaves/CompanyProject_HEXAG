package com.npotaves.CompanyApplication.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.npotaves.CompanyApplication.application.usecases.CompanyService;
import com.npotaves.CompanyApplication.domain.model.dto.CompanyDto;
import com.npotaves.CompanyApplication.domain.model.dto.request.CompanyRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void createCompany() throws Exception {
        CompanyRequest request = new CompanyRequest();
        request.setCompanyName("Test Company");
        request.setCuit("22234567889");

        CompanyDto response = new CompanyDto();
        response.setCompanyName("Test Company");

        when(companyService.createNew(any(CompanyRequest.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.companyName").value("Test Company"));

        verify(companyService, times(1)).createNew(any(CompanyRequest.class));
    }

    @Test
    void createCompany_InvalidRequest() throws Exception {
        CompanyRequest request = new CompanyRequest();

        mockMvc.perform(MockMvcRequestBuilders.post("/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getTransactionLastMonth_WithResults() throws Exception {
        List<CompanyDto> companies = List.of(new CompanyDto());
        when(companyService.getTransactionLastMonth()).thenReturn(companies);

        mockMvc.perform(MockMvcRequestBuilders.get("/company/transaction-last-month"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(companies.size()));

        verify(companyService, times(1)).getTransactionLastMonth();
    }

    @Test
    void getTransactionLastMonth_EmptyList() throws Exception {
        when(companyService.getTransactionLastMonth()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/company/transaction-last-month"))
                .andExpect(status().isNoContent());

        verify(companyService, times(1)).getTransactionLastMonth();
    }
}

