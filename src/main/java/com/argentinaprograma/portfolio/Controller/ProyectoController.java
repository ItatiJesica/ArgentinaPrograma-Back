package com.argentinaprograma.portfolio.Controller;

import com.argentinaprograma.portfolio.DTO.EducacionDto;
import com.argentinaprograma.portfolio.DTO.ProyectoDto;
import com.argentinaprograma.portfolio.Service.EducacionService;
import com.argentinaprograma.portfolio.Service.ProyectoService;
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
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("/proyecto/listar")
    public ResponseEntity<List<ProyectoDto>> listarProyecto(){
        return new ResponseEntity<>(proyectoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/proyecto/{id}")
    public ResponseEntity<ProyectoDto> obtenerProyecto(@PathVariable Long id){
        ProyectoDto proyectoDto = proyectoService.findById(id);
        return ResponseEntity.ok(proyectoDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyecto/crear")
    public ResponseEntity<ProyectoDto> crearProyecto(@Valid @RequestBody ProyectoDto proyectoDto){
        return new ResponseEntity<>(proyectoService.save(proyectoDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/proyecto/editar/{id}")
    public ResponseEntity<ProyectoDto> editarProyecto(@PathVariable Long id, @Valid @RequestBody ProyectoDto proyectoDto){

        ProyectoDto proyectoEncontrado = proyectoService.findById(id);

        if(proyectoEncontrado== null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            proyectoEncontrado.setIdPro(proyectoDto.getIdPro());
            proyectoEncontrado.setDescripcion(proyectoDto.getDescripcion());
            proyectoEncontrado.setLogo(proyectoDto.getLogo());
            proyectoEncontrado.setNombre(proyectoDto.getNombre());
            proyectoEncontrado.setPersona(proyectoDto.getPersona());
            return new ResponseEntity<>(proyectoService.save(proyectoEncontrado), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/proyecto/eliminar/{id}")
    public ResponseEntity<?> eliminarProyecto(@PathVariable Long id ){
        proyectoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
