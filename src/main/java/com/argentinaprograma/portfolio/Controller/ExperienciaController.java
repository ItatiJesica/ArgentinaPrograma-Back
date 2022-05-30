package com.argentinaprograma.portfolio.Controller;

import com.argentinaprograma.portfolio.DTO.ExperienciaDto;
import com.argentinaprograma.portfolio.Service.ExperienciaService;
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
@CrossOrigin(origins= "*")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    @GetMapping("/experiencia/listar")
    public ResponseEntity<List<ExperienciaDto>> listarExperiencia(){
        return new ResponseEntity<>(experienciaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/experiencia/{id}")
    public ResponseEntity<ExperienciaDto> obtenerExperiencia(@PathVariable Long id){
        ExperienciaDto experienciaDto = experienciaService.findById(id);
        return ResponseEntity.ok(experienciaDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experiencia/crear")
    public ResponseEntity<ExperienciaDto> crearExperiencia(@Valid @RequestBody ExperienciaDto experienciaDto){
        return new ResponseEntity<>(experienciaService.save(experienciaDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/experiencia/editar/{id}")
    public ResponseEntity<ExperienciaDto> editarExperiencia(@PathVariable Long id, @Valid @RequestBody  ExperienciaDto experienciaDto){

        ExperienciaDto experienciaEncontrada = experienciaService.findById(id);

        if(experienciaEncontrada== null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            experienciaEncontrada.setIdExp(experienciaDto.getIdExp());
            experienciaEncontrada.setEmpresa(experienciaDto.getEmpresa());
            experienciaEncontrada.setFin(experienciaDto.getFin());
            experienciaEncontrada.setInicio(experienciaDto.getInicio());
            experienciaEncontrada.setLogo(experienciaDto.getLogo());
            experienciaEncontrada.setPuesto(experienciaDto.getPuesto());
            experienciaEncontrada.setTipo(experienciaDto.getTipo());
            experienciaEncontrada.setPersona(experienciaDto.getPersona());
            return new ResponseEntity<>(experienciaService.save(experienciaEncontrada), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/experiencia/eliminar/{id}")
    public ResponseEntity<?> eliminarExperiencia(@PathVariable Long id ){
        experienciaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
