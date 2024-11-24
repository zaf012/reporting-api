package com.zaferakgul.reporting_api.service.base;

import com.zaferakgul.reporting_api.models.TransactionReportRequest;
import com.zaferakgul.reporting_api.models.TransactionReportResponse;

public interface TransactionReportService {
    TransactionReportResponse getTransactionReport(TransactionReportRequest request);
}
