package com.argentinaprograma.portfolio.Controller;

import com.argentinaprograma.portfolio.DTO.EducacionDto;
import com.argentinaprograma.portfolio.Service.EducacionService;
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
public class EducacionController {

    @Autowired
    private EducacionService educacionService;

    @GetMapping("/educacion/listar")
    public ResponseEntity<List<EducacionDto>> listarEducacion(){
        return new ResponseEntity<>(educacionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/educacion/{id}")
    public ResponseEntity<EducacionDto> obtenerEducacion(@PathVariable Long id){
        EducacionDto educacionDto = educacionService.findById(id);
        return ResponseEntity.ok(educacionDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/educacion/crear")
    public ResponseEntity<EducacionDto> crearEducacion(@Valid @RequestBody EducacionDto educacionDto){
        return new ResponseEntity<>(educacionService.save(educacionDto), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/educacion/editar/{id}")
    public ResponseEntity<EducacionDto> editarEducacion(@PathVariable Long id, @Valid @RequestBody EducacionDto educacionDto){

        EducacionDto educacionEncontrada = educacionService.findById(id);

        if(educacionEncontrada== null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            educacionEncontrada.setIdEd(educacionDto.getIdEd());
            educacionEncontrada.setInstitucion(educacionDto.getInstitucion());
            educacionEncontrada.setInicio(educacionDto.getInicio());
            educacionEncontrada.setFin(educacionDto.getFin());
            educacionEncontrada.setTitulo(educacionDto.getTitulo());
            educacionEncontrada.setUbicacion(educacionDto.getUbicacion());
            educacionEncontrada.setLogo(educacionDto.getLogo());
            educacionEncontrada.setPersona(educacionDto.getPersona());
            return new ResponseEntity<>(educacionService.save(educacionEncontrada), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/educacion/eliminar/{id}")
    public ResponseEntity<?> eliminarEducacion(@PathVariable Long id ){
        educacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
