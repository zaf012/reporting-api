package com.zaferakgul.reporting_api.service;


import com.zaferakgul.reporting_api.config.RestTemplateConfig;
import com.zaferakgul.reporting_api.models.AuthRequest;
import com.zaferakgul.reporting_api.models.AuthResponse;
import com.zaferakgul.reporting_api.models.TransactionQueryRequest;
import com.zaferakgul.reporting_api.models.TransactionQueryResponse;
import com.zaferakgul.reporting_api.service.base.AuthService;
import com.zaferakgul.reporting_api.service.base.TransactionQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class SimpleTransactionQueryService implements TransactionQueryService {

    private final RestTemplateConfig restTemplateConfig;
    private static final Logger log = LoggerFactory.getLogger(SimpleTransactionQueryService.class.getName());
    private final AuthService authService;
    @Value("${reportingApi.url.transactionList}")
    private String transactionList;
    @Value("${reportingApi.apiKey}")
    private String apiKey;

    public SimpleTransactionQueryService(RestTemplateConfig restTemplateConfig, AuthService authService) {
        this.restTemplateConfig = restTemplateConfig;
        this.authService = authService;
    }

    @Override
    public TransactionQueryResponse queryTransactions(TransactionQueryRequest request) {

        AuthRequest authRequest = new AuthRequest();
        AuthResponse login = authService.login(authRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", login.getToken());

        HttpEntity<TransactionQueryRequest> entity = new HttpEntity<>(request, headers);

        var url = transactionList + "?apiKey=" + apiKey;

        try {
            ResponseEntity<TransactionQueryResponse> response = restTemplateConfig.restTemplate().exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    TransactionQueryResponse.class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return response.getBody();
            }

            throw new RuntimeException("Transaction query failed");

        } catch (Exception e) {
            log.error("Transaction query error: ", e);
            throw new RuntimeException("Transaction query request failed", e);
        }
    }

    @Override
    public TransactionQueryResponse getNextPage(String nextPageUrl) {

        AuthRequest authRequest = new AuthRequest();
        AuthResponse login = authService.login(authRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", login.getToken());


        HttpEntity<Void> entity = new HttpEntity<>(headers);

        if (nextPageUrl.isBlank()) {
            throw new RuntimeException("No next page url found");
        }

        var url = nextPageUrl + "?apiKey=" + apiKey;

        try {
            ResponseEntity<TransactionQueryResponse> response = restTemplateConfig.restTemplate().exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    TransactionQueryResponse.class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return response.getBody();
            }

            throw new RuntimeException("Next page request failed");

        } catch (Exception e) {
            log.error("Next page error: ", e);
            throw new RuntimeException("Next page request failed", e);
        }
    }

    @Override
    public TransactionQueryResponse getPrevPage(String prevPageUrl) {

        AuthRequest authRequest = new AuthRequest();
        AuthResponse login = authService.login(authRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", login.getToken());

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        if (prevPageUrl.isBlank()) {
            throw new RuntimeException("No previous page url found");
        }

        var url = prevPageUrl + "?apiKey=" + apiKey;

        try {
            ResponseEntity<TransactionQueryResponse> response = restTemplateConfig.restTemplate().exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    TransactionQueryResponse.class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return response.getBody();
            }

            throw new RuntimeException("Previous page request failed");

        } catch (Exception e) {
            log.error("Previous page error: ", e);
            throw new RuntimeException("Previous page request failed", e);
        }
    }
}
