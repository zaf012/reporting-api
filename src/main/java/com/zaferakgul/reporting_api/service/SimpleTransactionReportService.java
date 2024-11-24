package com.zaferakgul.reporting_api.service;

import com.zaferakgul.reporting_api.config.RestTemplateConfig;
import com.zaferakgul.reporting_api.models.AuthRequest;
import com.zaferakgul.reporting_api.models.AuthResponse;
import com.zaferakgul.reporting_api.models.TransactionReportRequest;
import com.zaferakgul.reporting_api.models.TransactionReportResponse;
import com.zaferakgul.reporting_api.service.base.AuthService;
import com.zaferakgul.reporting_api.service.base.TransactionReportService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class SimpleTransactionReportService implements TransactionReportService {

    private final RestTemplateConfig restTemplateConfig;
    private final AuthService authService;
    @Value("${reportingApi.url.transactionReport}")
    private String transactionUrl;
    @Value("${reportingApi.apiKey}")
    private String apiKey;

    public SimpleTransactionReportService(RestTemplateConfig restTemplateConfig1, AuthService authService) {
        this.restTemplateConfig = restTemplateConfig1;
        this.authService = authService;
    }

    @Override
    public TransactionReportResponse getTransactionReport(TransactionReportRequest request) {

        AuthRequest authRequest = new AuthRequest();
        AuthResponse login = authService.login(authRequest);

        var headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", login.getToken());

        var entity = new HttpEntity<>(request, headers);

        var url = transactionUrl + "?apiKey=" + apiKey;

        var responseEntity = restTemplateConfig.restTemplate().postForEntity(url, entity, TransactionReportResponse.class);

        return responseEntity.getBody();
    }
}
