package com.app.threetier.service;

import com.app.threetier.domain.vo.CompanyVO;
import com.app.threetier.repository.CompanyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyDAO companyDAO;

    @Override
    public void registerCommuteStatus(CompanyVO companyVO) {
        companyDAO.save(companyVO);
    }
}
