package com.lyra.event.service;

import com.lyra.event.dto.usercredential.UserCredentialRequestDto;
import com.lyra.event.entities.Role;
import com.lyra.event.entities.User;
import com.lyra.event.entities.UserCredentials;
import com.lyra.event.repository.RoleRepository;
import com.lyra.event.repository.UserCredentialsRepository;
import com.lyra.event.repository.UserRepository;
import com.lyra.event.service.exceptions.BadRequestException;
import com.lyra.event.service.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Transactional
    public void registerUser(UserCredentialRequestDto dto) {
        User user = new User();
        user.setUsername(dto.username());
        user = userRepository.save(user);

        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setEmail(dto.email());
        userCredentials.setPassword(passwordEncoder.encode(dto.password()));
        userCredentials.setUser(user);
        userCredentialsRepository.save(userCredentials);
        var token = jwtTokenProvider.createVerificationToken(userCredentials.getEmail());
        String verificationUrl = "http://localhost:8080/api/v1/auth/verify?token=" + token;
        emailService.sendVerificationEmail(userCredentials.getEmail(), verificationUrl);
    }

    @Transactional
    public String verifyUser(String token) {

        if (!jwtTokenProvider.validateToken(token)) {
            throw new ForbiddenException("Invalid token");
        }

        var email = jwtTokenProvider.getEmailFromToken(token);
        var userCredentials = userCredentialsRepository.findByEmailCredentials(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (userCredentials.isEnabled()) {
            throw new BadRequestException("User already verified.");
        }

        userCredentials.setEnabled(true);
        userCredentials.addRole(roleRepository.getReferenceById(1L));
        userCredentialsRepository.save(userCredentials);
        return "User verified with sucess";
    }


}
