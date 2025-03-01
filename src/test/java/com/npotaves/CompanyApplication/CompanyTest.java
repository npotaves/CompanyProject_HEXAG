package com.npotaves.CompanyApplication;
import com.npotaves.CompanyApplication.domain.model.Company;
import com.npotaves.CompanyApplication.domain.model.Transaction;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    void shouldCreateCompanySuccesfully() {
        LocalDateTime now = LocalDateTime.now();
        Company company = new Company(1L, "12345678901", "Empresa S.A.", now, null);

        assertEquals(1L, company.getIdCompany());
        assertEquals("12345678901", company.getCuit());
        assertEquals("Empresa S.A.", company.getCompanyName());
        assertEquals(now, company.getSubscriptionDate());
        assertNull(company.getTransactions());
    }

    @Test
    void shouldAssignTransactionsSuccessfully() {
        Transaction transaction = new Transaction(1L, "1234", "5678", null, null, null);
        Company company = new Company();
        company.setTransactions(List.of(transaction));

        assertNotNull(company.getTransactions());
        assertEquals(1, company.getTransactions().size());
        assertEquals("1234", company.getTransactions().get(0).getCuentaCredito());
    }
}