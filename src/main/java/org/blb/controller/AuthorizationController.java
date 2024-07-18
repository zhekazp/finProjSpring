package org.blb.controller;

import lombok.RequiredArgsConstructor;
import org.blb.DTO.OneMessageDTO;
import org.blb.DTO.user.UserNewDTO;
import org.blb.controller.api.AuthApi;
import org.blb.security.dto.AuthRequest;
import org.blb.security.dto.AuthResponse;
import org.blb.service.user.UserAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorizationController implements AuthApi {
    private final UserAuthService userAuthService;

    @Override
    public ResponseEntity<AuthResponse> auth(AuthRequest request) {
        return new ResponseEntity<>(userAuthService.authentication(request.getEmail(), request.getPassword())
                , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OneMessageDTO> registration(UserNewDTO user) {
        userAuthService.addUser(user);
        return ResponseEntity.ok(new OneMessageDTO("Confirmation sanded to your email"));
    }

    @Override
    public ResponseEntity<OneMessageDTO> confirmation(Long id, String code) {
       return userAuthService.confirm(id, code);
    }


}
