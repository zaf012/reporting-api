package com.zaferakgul.reporting_api.controller;

import com.zaferakgul.reporting_api.models.TransactionQueryRequest;
import com.zaferakgul.reporting_api.models.TransactionQueryResponse;
import com.zaferakgul.reporting_api.models.TransactionReportRequest;
import com.zaferakgul.reporting_api.models.TransactionReportResponse;
import com.zaferakgul.reporting_api.service.base.TransactionQueryService;
import com.zaferakgul.reporting_api.service.base.TransactionReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionQueryController {

    private final TransactionQueryService transactionQueryService;

    public TransactionQueryController(TransactionQueryService transactionQueryService) {
        this.transactionQueryService = transactionQueryService;
    }

    @PostMapping("/list")
    public TransactionQueryResponse getTransactionReport(
            @ModelAttribute TransactionQueryRequest request
    ) {

        return transactionQueryService.queryTransactions(request);
    }

    @PostMapping("/next-page")
    public TransactionQueryResponse getNextPageTransactionReport(
            @RequestParam String nextPageUrl
    ) {

        return transactionQueryService.getNextPage(nextPageUrl);
    }

    @PostMapping("/prev-page")
    public TransactionQueryResponse getPrevPageTransactionReport(
            @RequestParam String prevPageUrl,
            @RequestHeader("Authorization") String jwtToken
    ) {

        return transactionQueryService.getPrevPage(prevPageUrl);
    }


}
