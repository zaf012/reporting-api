package com.zaferakgul.reporting_api.service.base;

import com.zaferakgul.reporting_api.models.AuthRequest;
import com.zaferakgul.reporting_api.models.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest request);
}
