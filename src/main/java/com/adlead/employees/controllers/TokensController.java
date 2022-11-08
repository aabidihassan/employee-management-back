package com.adlead.employees.controllers;

import com.adlead.employees.security.JwtUtil;
import com.adlead.employees.services.UtilisateurService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/token")
public class TokensController {

    private UtilisateurService utilisateurService;

    @Autowired
    public TokensController(UtilisateurService utilisateurService){
        this.utilisateurService = utilisateurService;
    }

    @GetMapping(path = "/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String authToken = request.getHeader(JwtUtil.AUTH_HEADER);
        if(authToken!=null && authToken.startsWith(JwtUtil.PREFIX)){
            try {
                String jwt = authToken.substring(JwtUtil.PREFIX.length());
                String jwtAccessToken = JwtUtil.createAccessTokenFromRefreshToken(jwt, request.getRequestURL().toString(), utilisateurService);

                Map<String, String> idToken = new HashMap<>();
                idToken.put("accesstoken", jwtAccessToken);
                idToken.put("refreshtoken", jwt);
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(), idToken);
            }catch (Exception e){
                throw e;
            }

        }
        else throw new RuntimeException("Refresh Token Required");
    }

}
