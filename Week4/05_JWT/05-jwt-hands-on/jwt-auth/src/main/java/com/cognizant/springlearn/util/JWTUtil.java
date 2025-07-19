package com.cognizant.springlearn.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {

  private final Key key;

  public JWTUtil(@Value("${jwt.secret}") String secret) {
    this.key = Keys.hmacShaKeyFor(secret.getBytes());
  }

  public String generateToken(String username) {
    long now = System.currentTimeMillis();
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date(now))
        .setExpiration(new Date(now + 1000 * 60 * 60)) // 1 hour
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }
}
