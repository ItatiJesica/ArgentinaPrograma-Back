package com.argentinaprograma.portfolio.Controller;

import com.argentinaprograma.portfolio.DTO.PersonaDto;
import com.argentinaprograma.portfolio.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins="*")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/persona/listar")
    public ResponseEntity<List<PersonaDto>> listarPersona(){
        return new ResponseEntity<>(personaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<PersonaDto> obtenerPersona(@PathVariable Long id){
        PersonaDto personaDto = personaService.findById(id);
        return ResponseEntity.ok(personaDto);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/crear")
    public ResponseEntity<PersonaDto> crearPersona(@Valid @RequestBody PersonaDto personaDto){
        return new ResponseEntity<>(personaService.save(personaDto), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persona/editar/{id}")
    public ResponseEntity<PersonaDto> editarPersona(@PathVariable Long id, @Valid @RequestBody PersonaDto personaDto){

        PersonaDto personaEncontrada = personaService.findById(id);

        if(personaEncontrada== null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            personaEncontrada.setId(personaDto.getId());
            personaEncontrada.setNombre(personaDto.getNombre());
            personaEncontrada.setContacto(personaDto.getContacto());
            personaEncontrada.setDescripcion(personaDto.getDescripcion());
            personaEncontrada.setFoto(personaDto.getFoto());
            personaEncontrada.setTitulo(personaDto.getTitulo());
            personaEncontrada.setUbicacion(personaDto.getUbicacion());
            return new ResponseEntity<>(personaService.save(personaEncontrada), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
