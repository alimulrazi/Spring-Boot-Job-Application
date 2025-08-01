package com.ali.first_job_app.authentication.service;

import com.ali.first_job_app.authentication.entity.TokenBlacklist;
import com.ali.first_job_app.authentication.repository.TokenBlacklistRepository;
import com.ali.first_job_app.authentication.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class TokenBlacklistService {

    @Autowired
    private TokenBlacklistRepository tokenBlacklistRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public void blacklistToken(String token) {
        if (!isTokenBlacklisted(token)) {
            LocalDateTime expiresAt = jwtUtil.getExpirationDateFromToken(token)
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

            TokenBlacklist blacklistEntry = new TokenBlacklist(token, expiresAt);
            tokenBlacklistRepository.save(blacklistEntry);
        }
    }

    public boolean isTokenBlacklisted(String token) {
        return tokenBlacklistRepository.existsByToken(token);
    }

    @Scheduled(fixedRate = 3600000) // Run every hour
    public void cleanupExpiredTokens() {
        tokenBlacklistRepository.deleteExpiredTokens(LocalDateTime.now());
    }
}
