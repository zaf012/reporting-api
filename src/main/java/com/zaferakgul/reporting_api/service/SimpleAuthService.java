package com.zaferakgul.reporting_api.service;

import com.zaferakgul.reporting_api.config.RestTemplateConfig;
import com.zaferakgul.reporting_api.models.AuthRequest;
import com.zaferakgul.reporting_api.models.AuthResponse;
import com.zaferakgul.reporting_api.service.base.AuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SimpleAuthService implements AuthService {
    @Value("${reportingApi.url}")
    private String testUrl;
    @Value("${reportingApi.login.email}")
    private String email;
    @Value("${reportingApi.login.password}")
    private String password;
    private final RestTemplateConfig restTemplateConfig;

    public SimpleAuthService(RestTemplateConfig restTemplateConfig) {
        this.restTemplateConfig = restTemplateConfig;
    }

    @Override
    public AuthResponse login(AuthRequest request) {

        request.setEmail(email);
        request.setPassword(password);

        AuthResponse authResponse = restTemplateConfig
                .restTemplate()
                .postForObject(testUrl, request, AuthResponse.class);

        if (authResponse == null || authResponse.getToken() == null) {
            throw new RuntimeException("Authentication failed");
        }
        return authResponse;
    }
}
