package com.npotaves.CompanyApplication.infraestructure.adapter.repository;

import com.npotaves.CompanyApplication.infraestructure.adapter.entity.CompanyEntity;
import com.npotaves.CompanyApplication.infraestructure.adapter.mapper.CompanyDboMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    @Query("SELECT c FROM CompanyEntity c WHERE  c.subscriptionDate >= :startDate AND c.subscriptionDate < :endDate")
    List<CompanyEntity> findCompaniesSubscribedLastMonth(@Param("startDate") LocalDateTime startDate,
                                                         @Param("endDate") LocalDateTime endDate);
    @Query("SELECT DISTINCT c FROM CompanyEntity c JOIN c.transactions t " +
            "WHERE t.transactionDate >= :startDate AND t.transactionDate < :endDate")
    List<CompanyEntity> findCompaniesWithTransfersLastMonth(@Param("startDate") LocalDateTime startDate,
                                                            @Param("endDate") LocalDateTime endDate);
}
