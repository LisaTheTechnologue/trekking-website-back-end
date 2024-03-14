package com.ngantcb.trekking.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    // at least 256 bits
    public static final String JWT_SECRET = "2072e45c4ee1e59456ce4a10ad6a6e03fa464ae7146bd78782667f0fb9fbf3ae9985e5514d9bc13a8af725d22f82a432971c4684e87fd0861066e0b93c209a7bd436bbe528bd12e03a94d8320dfbfc98128c3604d3d52963f9919775bb7318c012e7b8ba91124f8653fc071167dac3fbde0cfb68d4fdfab63ee39f33711186f145b1c7afcf303545ebd17f204184cc6ca14f0c8fe0131d13db5bc48de90be31fec87b0352a1b2dc4d5368c006464a4d056b68266ad50f0f8c24f44b72a7a6a0b02cb91e3095aa8761da08197ef74ced65574200aee2fc94d91e10ffefb85575ac3f29b18f6d3bb84127b945a4ce5d2170ce40a4690e981731418af2d89447617";
    private final long JWT_EXPIRATION = 3600L;
    public String generateToken(String username) {
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String username) {
        Date now = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSignKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    private Key getSignKey() {
        byte[] keybytes = Decoders.BASE64.decode(JWT_SECRET);
        return Keys.hmacShaKeyFor(keybytes);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignKey())
                .parseClaimsJws(token)
                .getBody();

    }

    public Boolean isTokenExpired (String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public boolean validateToken(String authToken, UserDetails userDetails) {
        final String username = extractUsername(authToken);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(authToken));
    }
}
