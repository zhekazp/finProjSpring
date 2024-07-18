package org.blb.controller.api;

import jakarta.validation.Valid;
import org.blb.DTO.OneMessageDTO;
import org.blb.DTO.user.UserNewDTO;
import org.blb.security.dto.AuthRequest;
import org.blb.security.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173")
public interface AuthApi {
    @PostMapping("/auth")
    public ResponseEntity<AuthResponse> auth(@RequestBody @Valid AuthRequest request);

    @PostMapping("/registration")
    public ResponseEntity<OneMessageDTO> registration(@RequestBody @Valid UserNewDTO user);

    @GetMapping("/confirmation")
    public ResponseEntity<OneMessageDTO> confirmation(@RequestParam("id") Long id,
                                               @RequestParam("code") String code);
}
