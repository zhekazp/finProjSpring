package org.blb.service.user;

import org.blb.DTO.OneMessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.blb.DTO.user.UserNewDTO;
import org.blb.models.user.Role;
import org.blb.models.user.State;
import org.blb.models.user.User;
import org.blb.repository.RoleRepository;
import org.blb.repository.UserRepository;
import org.blb.security.dto.AuthResponse;
import org.blb.security.service.JwtTokenProvider;
import org.blb.service.mail.MailCreateUtil;
import org.blb.service.mail.UserMailSender;
import org.blb.service.util.UserConvert;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserAuthService {
    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final UserConvert userConvert;
    private final UserFindService userFindService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;
    private final MailCreateUtil mailCreateUtil;
    private final UserMailSender userMailSender;

    @Transactional
    public void addUser(UserNewDTO user) {
        userFindService.findUserByEmail(user.getEmail());
        Role role = roleRepository.findByRole("USER");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        String codeValue = UUID.randomUUID().toString();
        User newUser = userConvert.fromDTOtoUser(user, role, State.NOT_CONFIRMED);
        newUser.setCode(codeValue);
        repository.save(newUser);
        sendEmail(newUser, codeValue);
    }


    public AuthResponse authentication(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        password
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication.getName());

        return new AuthResponse(jwt);
    }
    public ResponseEntity<OneMessageDTO> confirm(Long id, String code){
        User user=userFindService.findUserById(id);
        if(code.equals(user.getCode())){
            user.setCode("");
            user.setState(State.CONFIRMED);
            repository.save(user);
            return ResponseEntity.ok(new OneMessageDTO("User confirmed successfully"));
        }
            return ResponseEntity.badRequest().body(new OneMessageDTO("Invalid confirmation code"));
    }


    private void sendEmail(User user, String code) {
        String link = "?id=" + (user.getId()) + "&code=" + code;
        String html = mailCreateUtil.createConfirmationMail(user.getName(), link);
        userMailSender.send(user.getEmail(), "Registration", html);
    }
}
