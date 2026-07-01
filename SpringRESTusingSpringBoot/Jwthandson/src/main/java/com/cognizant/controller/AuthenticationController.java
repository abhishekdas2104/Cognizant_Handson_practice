package com.cognizant.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class AuthenticationController {
@GetMapping("/authenticate")
public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
String user = getUser(authHeader);
String token = generateJwt(user);
Map<String, String> map = new HashMap<>();
map.put("token", token);
return map;
}
private String getUser(String authHeader) {
String encodedCredentials = authHeader.substring("Basic ".length());
byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
String credentials = new String(decodedBytes);
String user = credentials.substring(0, credentials.indexOf(":"));
return user;
}
private String generateJwt(String user) {
JwtBuilder builder = Jwts.builder();
builder.setSubject(user);
builder.setIssuedAt(new Date());
builder.setExpiration(new Date((new Date()).getTime() + 1200000));
builder.signWith(io.jsonwebtoken.security.Keys.hmacShaKeyFor("secretkeysecretkeysecretkey123456".getBytes()));
String token = builder.compact();
return token;
}
}
