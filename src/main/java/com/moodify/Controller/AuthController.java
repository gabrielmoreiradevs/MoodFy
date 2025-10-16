package com.moodify.Controller;

import com.moodify.Config.TokenService;
import com.moodify.Exceptions.UsernameOrPasswordInvalidException;
import com.moodify.Mapper.UserMapper;
import com.moodify.Model.User;
import com.moodify.Service.UserService;
import com.moodify.request.LoginRequest;
import com.moodify.request.UserRequest;
import com.moodify.response.ContentsResponse;
import com.moodify.response.LoginResponse;
import com.moodify.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

@Tag(name = "Auth", description = "Recurso responsavel pelo gerenciamento de Usuarios(Token)")

@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Operation(summary = "Registrar um Usuario")
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = UserResponse.class)))
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){
        UserResponse saved = userService.save(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Operation(summary = "Logar em um Usuario")
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = UserResponse.class)))
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        try{
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            Authentication authentication = authenticationManager.authenticate(userAndPass);

            User user = (User) authentication.getPrincipal();
            String token = tokenService.generateToken(user);

            return ResponseEntity.ok(new LoginResponse(token));
        }catch(BadCredentialsException e){
            throw new UsernameOrPasswordInvalidException("Usuário ou Senha Invalido");
        }
    }
}
