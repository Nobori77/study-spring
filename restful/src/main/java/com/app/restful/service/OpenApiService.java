package com.app.restful.service;

import com.app.restful.domain.dto.CongestionDTO;
import com.app.restful.domain.dto.PetTourDTO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface OpenApiService {
    // 펫투어
    public List<PetTourDTO> fetchData() throws IOException;

    // 교통 체증
    public CongestionDTO fetchData2() throws IOException, URISyntaxException;
}