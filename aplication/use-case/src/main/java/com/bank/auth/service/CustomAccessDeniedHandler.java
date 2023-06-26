package com.bank.auth.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        String message = "Acceso denegado. No tienes permiso para acceder a este recurso.";
        String body = "{" +
                "\"data\": null," +
                "\"message\": \"" + message + "\"," +
                "\"status\": " + HttpServletResponse.SC_FORBIDDEN + "," +
                "}";

        response.getWriter().write(body);
    }
}