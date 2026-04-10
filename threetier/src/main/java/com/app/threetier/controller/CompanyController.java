package com.app.threetier.controller;

import com.app.threetier.domain.vo.CompanyVO;
import com.app.threetier.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/companies/*")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/check-in")
    public void goToCheckInForm(@ModelAttribute CompanyVO companyVO){;}

    @PostMapping("/check-in")
    public RedirectView checkIn(CompanyVO companyVO, String flag){
        LocalDateTime now = LocalDateTime.now();
//        년 달 일 시 분 초
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        int hours = now.getHour();
        int minutes = now.getMinute();

//        출근
        boolean isLateCondition = hours >= 9 && minutes > 0;

//        퇴근
        boolean isLeaveCondition = hours >= 18 && minutes >= 0;

//        출근 처리
        if(flag.equals("getToWork")){
            companyVO.setGetToWorkDateTime(format);
            companyService.registerCommuteStatus(companyVO);
//            정상 출근 시간 초과 ? 지각 : 정상 출근
            return new RedirectView(isLateCondition ? "/companies/late" : "/companies/get-to-work");
        }else if(flag.equals("leaveToWork")){
            companyVO.setLeaveToWorkDateTime(format);
            companyService.registerCommuteStatus(companyVO);
//            정상 퇴근 시간 ? 퇴근 : 땡땡이
            return new RedirectView(isLeaveCondition ? "/companies/leave-to-work" : "/companies/work");
        }
        return new RedirectView("/companies/check-in");
    }

    @GetMapping("/get-to-work")
    public void goToGetToWork(){;}

    @GetMapping("/leave-to-work")
    public void goToLeaveWork(){;}

    @GetMapping("/late")
    public void goToLate(){;}

    @GetMapping("/work")
    public void goToWork(){;}

}
