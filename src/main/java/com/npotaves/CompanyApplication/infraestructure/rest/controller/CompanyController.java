package com.npotaves.CompanyApplication.infraestructure.rest.controller;

import com.npotaves.CompanyApplication.application.usecases.CompanyService;
import com.npotaves.CompanyApplication.domain.model.dto.CompanyDto;
import com.npotaves.CompanyApplication.domain.model.dto.request.CompanyRequest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @PostMapping()
    public ResponseEntity<CompanyDto> create(@Valid @RequestBody CompanyRequest companyRequest) {
        CompanyDto response = companyService.createNew(companyRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/transaction-last-month")
    public ResponseEntity<List<CompanyDto>> getTransactionLastMonth() {
        List<CompanyDto> transactions = companyService.getTransactionLastMonth();

        if (transactions.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 si la lista está vacía
        }

        return ResponseEntity.ok(transactions);
    }


    @GetMapping("/subscribed-last-month")
    public ResponseEntity<List<CompanyDto>> getSubscribedLastMonth() {
        List<CompanyDto> transactions = companyService.getSubscribedLastMonth();

        if (transactions.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 si la lista está vacía
        }

        return ResponseEntity.ok(transactions);
    }
}
