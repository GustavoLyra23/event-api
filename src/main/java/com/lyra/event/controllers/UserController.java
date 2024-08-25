package com.lyra.event.controllers;

import com.lyra.event.dto.user.UserDto;
import com.lyra.event.service.UserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<UserDto> getMe() {
        var user = userService.getMe();
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/picture")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<Void> updateProfilePicture(@NotNull(message = "pictue cant' be null")
                                                     @RequestParam("file") MultipartFile file) throws IOException {
        userService.updateProfilePicture(file);
        return ResponseEntity.noContent().build();
    }


}
