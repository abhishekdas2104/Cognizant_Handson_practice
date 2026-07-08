package com.example.jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.ArrayList;
@Component
public class JwtTokenProvider{
@Autowired
private JwtConfig jwtConfig;
public String createToken(String username){
Claims claims=Jwts.claims().setSubject(username);
Date now=new Date();
Date validity=new Date(now.getTime()+3600000);
return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity).signWith(SignatureAlgorithm.HS256,jwtConfig.getSecret()).compact();
}
public boolean validateToken(String token){
try{
Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(token);
return true;
}catch(Exception e){
return false;
}
}
public Authentication getAuthentication(String token){
String username=Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(token).getBody().getSubject();
return new UsernamePasswordAuthenticationToken(username,null,new ArrayList<>());
}
}
