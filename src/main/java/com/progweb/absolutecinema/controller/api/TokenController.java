package com.progweb.absolutecinema.controller.api;

import com.progweb.absolutecinema.controller.dto.LoginRequest;
import com.progweb.absolutecinema.controller.dto.LoginResponse;
import com.progweb.absolutecinema.model.Role;
import com.progweb.absolutecinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
public class TokenController {

    @Autowired
    private  JwtEncoder jwtEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest loginRequest) {

       var user = userRepository.findByUsername(loginRequest.username());

       if (user.isEmpty() || !user.get().isLoginValid(loginRequest, passwordEncoder)) {
           throw new BadCredentialsException("user or password is invalid!");
       }

       var now = Instant.now();
       var expiresIn = 300L;

        String scope = user.get().getRole()
                .stream()
                .map(Role::getName)
                .collect(Collectors
                        .joining(" "));

       var claims = JwtClaimsSet.builder()
               .issuer("absolute-cinema")
               .issuedAt(now)
               .expiresAt(now.plusSeconds(expiresIn))
               .subject(user.get().getId().toString())
               .claim("scope", scope)
               .build();

       var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));
    }


}
