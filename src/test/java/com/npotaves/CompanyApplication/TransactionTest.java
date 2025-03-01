package com.npotaves.CompanyApplication;
import com.npotaves.CompanyApplication.domain.model.Company;
import com.npotaves.CompanyApplication.domain.model.Transaction;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void shouldCreateTransactionSuccesfully() {
        LocalDateTime now = LocalDateTime.now();
        Transaction transaction = new Transaction(1L, "1234", "5678", new BigDecimal("500.00"), now, null);

        assertEquals(1L, transaction.getIdTransaction());
        assertEquals("1234", transaction.getCuentaCredito());
        assertEquals("5678", transaction.getCuentaDebito());
        assertEquals(new BigDecimal("500.00"), transaction.getImporte());
        assertEquals(now, transaction.getTransactionDate());
        assertNull(transaction.getCompany());
    }

    @Test
    void
    shouldAssignCompanyToTransaction() {
        Company company = new Company(2L, "98765432100", "Empresa B", LocalDateTime.now(), null);
        Transaction transaction = new Transaction();
        transaction.setCompany(company);

        assertNotNull(transaction.getCompany());
        assertEquals("98765432100", transaction.getCompany().getCuit());
    }
}