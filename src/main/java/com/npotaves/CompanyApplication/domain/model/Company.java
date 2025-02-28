package com.npotaves.CompanyApplication.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Company {
    private Long idCompany;
    private String cuit;
    private String companyName;
    private LocalDateTime subscriptionDate;
    private List<Transaction> transactions;

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public String getCuit() {
        return cuit;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
