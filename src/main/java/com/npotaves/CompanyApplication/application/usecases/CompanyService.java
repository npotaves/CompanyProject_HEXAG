package com.npotaves.CompanyApplication.application.usecases;

import com.npotaves.CompanyApplication.application.mapper.CompanyDtoMapper;
import com.npotaves.CompanyApplication.application.mapper.CompanyRequestMapper;
import com.npotaves.CompanyApplication.domain.model.dto.CompanyDto;
import com.npotaves.CompanyApplication.domain.model.dto.request.CompanyRequest;
import com.npotaves.CompanyApplication.domain.port.CompanyPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public interface CompanyService {
    CompanyDto createNew(CompanyRequest request);

    List<CompanyDto> getSubscribedLastMonth();

    List<CompanyDto> getTransactionLastMonth();
}
