package com.app.threetier.mapper;

import com.app.threetier.domain.vo.CompanyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CompanyMapper {
    public void insert(CompanyVO companyVO);
}

