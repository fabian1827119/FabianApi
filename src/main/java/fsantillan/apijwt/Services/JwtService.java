package fsantillan.apijwt.Services;

import org.springframework.security.core.userdetails.UserDetails;

import fsantillan.apijwt.Common.Models.User;

public interface JwtService {
    String getToken(User user);
    String getUsernameFromToken(String token);
    boolean isTokenValid(String token, UserDetails userDetails);

}
