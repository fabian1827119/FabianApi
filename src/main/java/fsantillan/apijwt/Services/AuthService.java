package fsantillan.apijwt.Services;

import fsantillan.apijwt.Common.Models.LoginRequest;
import fsantillan.apijwt.Common.Models.RegisterRequest;
import fsantillan.apijwt.Common.Models.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse register(RegisterRequest request);
}
