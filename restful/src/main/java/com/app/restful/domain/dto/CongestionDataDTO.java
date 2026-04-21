package com.app.restful.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CongestionDataDTO {
    @JsonProperty("요일구분")
    private String day;
    @JsonProperty("호선")
    private String line;
    @JsonProperty("역번호")
    private String stationNumber;
    @JsonProperty("출발역")
    private String startStation;
    @JsonProperty("상하구분")
    private String upOrDownStation;
    @JsonProperty("5시30분")
    private String time530;
    @JsonProperty("6시00분")
    private String time600;
    @JsonProperty("7시00분")
    private String time700;
    @JsonProperty("7시30분")
    private String time730;
}
