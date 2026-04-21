package com.app.restful.service;

import com.app.restful.domain.dto.CongestionDTO;
import com.app.restful.domain.dto.PetTourDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OpenApiServiceImpl implements OpenApiService {

    //    환경 변수 값을 주입
    @Value("${api.base-url}")
    private String baseUrl;

    @Value("${api.area-based-list}")
    private String areaBasedList;

    @Value("${api.service-key}")
    private String serviceKey;

    private final ObjectMapper objectMapper;

    @Override
    public List<PetTourDTO> fetchData() throws IOException {

        //   빌드 패턴
        String urlStr = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .path(areaBasedList)
                .queryParam("serviceKey", serviceKey)
                .queryParam("MobileOS", "ETC")
                .queryParam("MobileApp", "TestApp")
                .queryParam("_type", "json")
                .build()
                .toUriString();

        URL url = new URL(urlStr);
        log.info(urlStr);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line);
        }

        bufferedReader.close();

//        JSON 응답
        JsonNode jsonResponse = objectMapper.readTree(result.toString());
        if(jsonResponse.has("error")){
            return null;
        }

        JsonNode itemsArray = jsonResponse.get("response").get("body").get("items").get("item");
        List<PetTourDTO> petTourList = new ArrayList<>();

        for(JsonNode item : itemsArray){
            PetTourDTO petTourDTO = new PetTourDTO();
            petTourDTO.setTitle(item.get("title").asText());
            petTourDTO.setAreacode(item.get("areacode").asText());
            petTourDTO.setAddr1(item.get("addr1").asText());
            petTourDTO.setAddr2(item.get("addr2").asText());
            petTourDTO.setTel(item.get("tel").asText());
            petTourDTO.setContentid(item.get("contentid").asText());
            petTourDTO.setFirstimage(item.get("firstimage").asText());
            petTourDTO.setFirstimage2(item.get("firstimage2").asText());
            petTourDTO.setZipcode(item.get("zipcode").asText());

            petTourList.add(petTourDTO);
        }

        return petTourList;
    }

    @Value("${api.base-url2}")
    private String baseUrl2;

    @Value("${api.uddi-9c79ebd1}")
    private String uddi;

    @Override
    public CongestionDTO fetchData2() throws IOException, URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        //   빌드 패턴
        String urlStr = UriComponentsBuilder
                .fromHttpUrl(baseUrl2)
                .path(uddi)
                .queryParam("serviceKey", serviceKey)
                .queryParam("page", 1)
                .queryParam("perPage", 10)
                .queryParam("_type", "json")
                .build()
                .toUriString();

        URI uri = new URI(urlStr);

        // 스프링 프레임워크5 이상 restTemplate
        CongestionDTO response = restTemplate.getForObject(uri, CongestionDTO.class);
        return response;
    }
}









