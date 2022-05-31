package com.argentinaprograma.portfolio.Controller;

import com.argentinaprograma.portfolio.DTO.JwtDto;
import com.argentinaprograma.portfolio.DTO.LoginUsuarioDto;
import com.argentinaprograma.portfolio.DTO.MensajeDto;
import com.argentinaprograma.portfolio.DTO.NuevoUsuarioDto;
import com.argentinaprograma.portfolio.Model.Rol;
import com.argentinaprograma.portfolio.Model.Usuario;
import com.argentinaprograma.portfolio.Security.Enum.RolNombre;
import com.argentinaprograma.portfolio.Security.Jwt.JwtProvider;
import com.argentinaprograma.portfolio.Service.RolService;
import com.argentinaprograma.portfolio.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="*")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuarioDto nuevoUsuarioDto, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new MensajeDto("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(nuevoUsuarioDto.getNombreUsuario()))
            return new ResponseEntity(new MensajeDto("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuarioDto.getEmail()))
            return new ResponseEntity(new MensajeDto("ese email ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario =
                new Usuario(nuevoUsuarioDto.getNombre(), nuevoUsuarioDto.getNombreUsuario(), nuevoUsuarioDto.getEmail(),
                        passwordEncoder.encode(nuevoUsuarioDto.getPassword()));

        usuarioService.save(usuario);
        return new ResponseEntity(new MensajeDto("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuarioDto loginUsuarioDto, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new MensajeDto("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuarioDto.getNombreUsuario(), loginUsuarioDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
