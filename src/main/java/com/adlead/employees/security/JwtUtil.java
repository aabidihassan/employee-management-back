package com.adlead.employees.security;

import com.adlead.employees.models.Utilisateur;
import com.adlead.employees.services.UtilisateurService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.security.core.userdetails.User;

import java.util.Date;
import java.util.stream.Collectors;

public class JwtUtil {

	public static final String SECRET = "mySecret123";
    public static final String AUTH_HEADER = "Authorization";
    public static final String PREFIX = "Bearer ";
    public static final long EXPIRE_ACCESS_TOKEN = 60*60*1000;
    public static final long EXPIRE_REFRESH_TOKEN = 192*60*60*1000;


    private static final Algorithm algorithm = Algorithm.HMAC256(JwtUtil.SECRET);

    public static String createAccessToken(User user, String url){
        Algorithm algorithm = Algorithm.HMAC256(JwtUtil.SECRET);
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+JwtUtil.EXPIRE_ACCESS_TOKEN))
                .withIssuer(url)
                .withClaim("roles", user.getAuthorities().stream().map(ga->ga.getAuthority()).collect(Collectors.toList()))
                .sign(algorithm);
    }

    public static String createRefreshToken(User user, String url){
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+JwtUtil.EXPIRE_REFRESH_TOKEN))
                .withIssuer(url)
                .withClaim("roles", user.getAuthorities().stream().map(ga->ga.getAuthority()).collect(Collectors.toList()))
                .sign(JwtUtil.algorithm);
    }

    public static String createAccessTokenFromRefreshToken(String jwt, String url, UtilisateurService utilisateurService){
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
        String username = decodedJWT.getSubject();
        Utilisateur user = utilisateurService.loadUserByUsername(username);
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+JwtUtil.EXPIRE_ACCESS_TOKEN))
                .withIssuer(url)
                .withClaim("roles", user.getRoles().stream().map(ga->ga.getLibelle()).collect(Collectors.toList()))
                .sign(algorithm);
    }


}
