package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.util.JWTUtil;
import com.cognizant.springlearn.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JWTUtil jwtUtil;

  @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
  public Map<String, String> authenticate(HttpServletRequest request) {
    String authHeader = request.getHeader("Authorization");

    if (authHeader == null || !authHeader.startsWith("Basic ")) {
      throw new RuntimeException("Missing or invalid Authorization header.");
    }

    String base64Credentials = authHeader.substring("Basic ".length()).trim();
    byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
    String credentials = new String(credDecoded);
    final String[] values = credentials.split(":", 2);

    try {
      Authentication auth = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(values[0], values[1]));

      String token = jwtUtil.generateToken(values[0]);

      Map<String, String> response = new HashMap<>();
      response.put("token", token);
      return response;
    } catch (AuthenticationException e) {
      throw new RuntimeException("Invalid credentials");
    }
  }
}
