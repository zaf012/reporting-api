package com.zaferakgul.reporting_api.controller;

import com.zaferakgul.reporting_api.models.TransactionReportRequest;
import com.zaferakgul.reporting_api.models.TransactionReportResponse;
import com.zaferakgul.reporting_api.service.base.TransactionReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionReportController {

    private final TransactionReportService transactionReportService;

    public TransactionReportController(TransactionReportService transactionReportService) {
        this.transactionReportService = transactionReportService;
    }

    @PostMapping("/report")
    public TransactionReportResponse getTransactionReport(
            @RequestBody TransactionReportRequest request) {

        return transactionReportService.getTransactionReport(request);
    }
}
