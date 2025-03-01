package com.npotaves.CompanyApplication.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {

    private Long idTransaction;
    private String cuentaCredito;
    private String cuentaDebito;
    private BigDecimal importe;
    private LocalDateTime transactionDate;
    @JsonIgnore
    private Company company;

    public Transaction(Long idTransaction, String cuentaCredito, String cuentaDebito, BigDecimal importe, LocalDateTime transactionDate, Company company) {
        this.idTransaction = idTransaction;
        this.cuentaCredito = cuentaCredito;
        this.cuentaDebito = cuentaDebito;
        this.importe = importe;
        this.transactionDate = transactionDate;
        this.company = company;
    }

    public Transaction() {

    }

    public Long getIdTransaction() {
        return idTransaction;
    }

    public String getCuentaCredito() {
        return cuentaCredito;
    }

    public String getCuentaDebito() {
        return cuentaDebito;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public void setCuentaCredito(String cuentaCredito) {
        this.cuentaCredito = cuentaCredito;
    }

    public void setCuentaDebito(String cuentaDebito) {
        this.cuentaDebito = cuentaDebito;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
