package fsantillan.apijwt.Services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fsantillan.apijwt.Common.Enum.Role;
import fsantillan.apijwt.Common.Models.AuthResponse;
import fsantillan.apijwt.Common.Models.LoginRequest;
import fsantillan.apijwt.Common.Models.RegisterRequest;
import fsantillan.apijwt.Common.Models.User;
import fsantillan.apijwt.Repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
        .country(request.getCountry())
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .username(request.getUsername())
        .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }

}

