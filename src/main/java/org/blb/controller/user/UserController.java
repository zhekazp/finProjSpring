package org.blb.controller.user;

import lombok.RequiredArgsConstructor;
import org.blb.DTO.user.UserResponseDTO;
import org.blb.controller.api.user.UserAPI;
import org.blb.service.user.UserFindService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class UserController implements UserAPI {
    private final UserFindService userFindService;
    @Override
    public ResponseEntity<List<UserResponseDTO>> getUsers(Integer page) {
        return ResponseEntity.ok(userFindService.findAllUsers(page));
    }
}
