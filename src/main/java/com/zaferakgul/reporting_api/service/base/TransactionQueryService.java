package com.zaferakgul.reporting_api.service.base;

import com.zaferakgul.reporting_api.models.TransactionQueryRequest;
import com.zaferakgul.reporting_api.models.TransactionQueryResponse;

public interface TransactionQueryService {
    TransactionQueryResponse queryTransactions(TransactionQueryRequest request);

    TransactionQueryResponse getNextPage(String nextPageUrl);

    TransactionQueryResponse getPrevPage(String prevPageUrl);
}
