package com.cognizant.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
super(authenticationManager);
}
@Override
protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
String header = req.getHeader("Authorization");
if (header == null || !header.startsWith("Bearer ")) {
chain.doFilter(req, res);
return;
}
UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
SecurityContextHolder.getContext().setAuthentication(authentication);
chain.doFilter(req, res);
}
private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
String token = request.getHeader("Authorization");
if (token != null) {
Jws<Claims> jws;
try {
jws = Jwts.parserBuilder()
.setSigningKey(io.jsonwebtoken.security.Keys.hmacShaKeyFor("secretkeysecretkeysecretkey123456".getBytes()))
.build()
.parseClaimsJws(token.replace("Bearer ", ""));
String user = jws.getBody().getSubject();
if (user != null) {
return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
}
} catch (JwtException ex) {
return null;
}
return null;
}
return null;
}
}
