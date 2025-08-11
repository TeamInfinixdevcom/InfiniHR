/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinhihr.seguridad;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

  // use una key estable (por ejemplo vía properties); aquí fija para demo
  private final Key key = Keys.hmacShaKeyFor("esta-es-una-clave-super-secreta-de-32-bytes!!".getBytes());

  public String extractUsername(String token) {
    return Jwts.parserBuilder().setSigningKey(key).build()
        .parseClaimsJws(token).getBody().getSubject();
  }

  public boolean isTokenValid(String token, UserDetails user) {
    String username = extractUsername(token);
    return username.equals(user.getUsername()) && !isExpired(token);
  }

  public String generateToken(String username) {
    long now = System.currentTimeMillis();
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date(now))
        .setExpiration(new Date(now + 1000 * 60 * 60)) // 1 hora
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }

  private boolean isExpired(String token) {
    var exp = Jwts.parserBuilder().setSigningKey(key).build()
        .parseClaimsJws(token).getBody().getExpiration();
    return exp.before(new Date());
  }
}
