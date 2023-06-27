package com.bank.auth;

import com.bank.auth.service.JwtUtilService;
import com.bank.http.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService usuarioDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationReq authenticationReq) {
        logger.info("Autenticando al client {}", authenticationReq.getClientId());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationReq.getClientId(),
                        authenticationReq.getPassword()));

        final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
                authenticationReq.getClientId());

        final String jwt = jwtUtilService.generateToken(userDetails);

        return ResponseHandler.success("Success", new TokenInfo(jwt));
    }


//    @PostMapping("/logout")
//    public ResponseEntity<?> logout() {
//        var auth =  SecurityContextHolder.getContext().getAuthentication();
//        Map<String, String> mensaje = new HashMap<>();
//        mensaje.put("data", "Logout");
//        return ResponseEntity.ok(mensaje);
//    }
}
