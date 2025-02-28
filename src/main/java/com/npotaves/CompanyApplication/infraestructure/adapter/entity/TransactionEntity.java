package com.npotaves.CompanyApplication.infraestructure.adapter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.npotaves.CompanyApplication.domain.model.Company;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Long idTransaction;
    @Column(nullable = false)
    private BigDecimal importe;
    @Column(nullable = false)
    private String cuentaDebito;
    @Column(nullable = false)
    private String cuentaCredito;
    @Column(nullable= false)
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "id_company", nullable = false)
    @JsonIgnore
    private CompanyEntity company;

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public void setCuentaDebito(String cuentaDebito) {
        this.cuentaDebito = cuentaDebito;
    }

    public void setCuentaCredito(String cuentaCredito) {
        this.cuentaCredito = cuentaCredito;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public Long getIdTransaction() {
        return idTransaction;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public String getCuentaDebito() {
        return cuentaDebito;
    }

    public String getCuentaCredito() {
        return cuentaCredito;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public CompanyEntity getCompany() {
        return company;
    }
}
