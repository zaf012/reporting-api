package com.zaferakgul.reporting_api.service;

import com.zaferakgul.reporting_api.config.RestTemplateConfig;
import com.zaferakgul.reporting_api.models.AuthRequest;
import com.zaferakgul.reporting_api.models.AuthResponse;
import com.zaferakgul.reporting_api.models.TransactionReportRequest;
import com.zaferakgul.reporting_api.models.TransactionReportResponse;
import com.zaferakgul.reporting_api.service.base.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class TransactionReportServiceTest {


    @Mock
    private RestTemplateConfig restTemplateConfig;

    @Mock
    private AuthService authService;

    @Mock
    private RestTemplate restTemplate;

    private SimpleTransactionReportService transactionReportService;

    private static final String TEST_URL = "http://test-api/transactions";
    private static final String TEST_API_KEY = "test-api-key";
    private static final String TEST_TOKEN = "test-token";

    @BeforeEach
    void setUp() {
        transactionReportService = new SimpleTransactionReportService(restTemplateConfig, authService);
        ReflectionTestUtils.setField(transactionReportService, "transactionUrl", TEST_URL);
        ReflectionTestUtils.setField(transactionReportService, "apiKey", TEST_API_KEY);
        when(restTemplateConfig.restTemplate()).thenReturn(restTemplate);
    }

    @Test
    void getTransactionReport_Success() {
        // Arrange
        TransactionReportRequest request = new TransactionReportRequest();
        TransactionReportResponse expectedResponse = new TransactionReportResponse();

        AuthRequest authRequest = new AuthRequest();
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(TEST_TOKEN);

        when(authService.login(any(AuthRequest.class))).thenReturn(authResponse);

        HttpHeaders expectedHeaders = new HttpHeaders();
        expectedHeaders.setContentType(MediaType.APPLICATION_JSON);
        expectedHeaders.set("Authorization", TEST_TOKEN);

        when(restTemplate.postForEntity(
                eq(TEST_URL + "?apiKey=" + TEST_API_KEY),
                any(HttpEntity.class),
                eq(TransactionReportResponse.class)
        )).thenReturn(ResponseEntity.ok(expectedResponse));

        // Act
        TransactionReportResponse actualResponse = transactionReportService.getTransactionReport(request);

        // Assert
        assertNotNull(actualResponse);
        assertEquals(expectedResponse, actualResponse);

        verify(authService).login(any(AuthRequest.class));
        verify(restTemplate).postForEntity(
                eq(TEST_URL + "?apiKey=" + TEST_API_KEY),
                any(HttpEntity.class),
                eq(TransactionReportResponse.class)
        );
    }

    @Test
    void getTransactionReport_WhenAuthFails_ThrowsException() {
        // Arrange
        TransactionReportRequest request = new TransactionReportRequest();
        when(authService.login(any(AuthRequest.class))).thenThrow(new RuntimeException("Auth failed"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> {
            transactionReportService.getTransactionReport(request);
        });

        verify(authService).login(any(AuthRequest.class));
        verify(restTemplate, never()).postForEntity(
                any(String.class),
                any(HttpEntity.class),
                any(Class.class)
        );
    }

    @Test
    void getTransactionReport_WhenApiCallFails_ThrowsException() {
        // Arrange
        TransactionReportRequest request = new TransactionReportRequest();
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(TEST_TOKEN);

        when(authService.login(any(AuthRequest.class))).thenReturn(authResponse);
        when(restTemplate.postForEntity(
                any(String.class),
                any(HttpEntity.class),
                eq(TransactionReportResponse.class)
        )).thenThrow(new RuntimeException("API call failed"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> {
            transactionReportService.getTransactionReport(request);
        });

        verify(authService).login(any(AuthRequest.class));
        verify(restTemplate).postForEntity(
                any(String.class),
                any(HttpEntity.class),
                eq(TransactionReportResponse.class)
        );
    }
}
