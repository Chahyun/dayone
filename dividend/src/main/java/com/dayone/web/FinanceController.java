package com.dayone.web;

import com.dayone.service.FinanceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/finance")
@AllArgsConstructor
public class FinanceController {
    private final FinanceService financeService;

    @GetMapping("/dividend/{companyName}")
    public ResponseEntity<?> searchFinance(@PathVariable String companyName){
        var result = this.financeService.getDividendByCompanyName(companyName);
        log.info("get company dividend ->" + result.getCompany().getName());
        return ResponseEntity.ok(result);
    }
}
