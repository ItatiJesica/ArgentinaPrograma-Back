package com.argentinaprograma.portfolio.Controller;

import com.argentinaprograma.portfolio.DTO.ExperienciaDto;
import com.argentinaprograma.portfolio.DTO.HabilidadDto;
import com.argentinaprograma.portfolio.Service.ExperienciaService;
import com.argentinaprograma.portfolio.Service.HabilidadService;
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
public class HabilidadController {

    @Autowired
    private HabilidadService habilidadService;

    @GetMapping("/habilidad/listar")
    public ResponseEntity<List<HabilidadDto>> listarHabilidad(){
        return new ResponseEntity<>(habilidadService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/habilidad/{id}")
    public ResponseEntity<HabilidadDto> obtenerHabilidad(@PathVariable Long id){
        HabilidadDto habilidadDto = habilidadService.findById(id);
        return ResponseEntity.ok(habilidadDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/habilidad/crear")
    public ResponseEntity<HabilidadDto> crearHabilidad(@Valid @RequestBody HabilidadDto habilidadDto){
        return new ResponseEntity<>(habilidadService.save(habilidadDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/habilidad/editar/{id}")
    public ResponseEntity<HabilidadDto> editarHabilidad(@PathVariable Long id, @Valid @RequestBody HabilidadDto habilidadDto){

        HabilidadDto habilidadEncontrada = habilidadService.findById(id);

        if(habilidadEncontrada== null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            habilidadEncontrada.setIdHab(habilidadDto.getIdHab());
            habilidadEncontrada.setHabilidad(habilidadDto.getHabilidad());
            habilidadEncontrada.setPorcentaje(habilidadDto.getPorcentaje());
            habilidadEncontrada.setLogo(habilidadDto.getLogo());
            habilidadEncontrada.setPersona(habilidadDto.getPersona());
            return new ResponseEntity<>(habilidadService.save(habilidadEncontrada), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/habilidad/eliminar/{id}")
    public ResponseEntity<?> eliminarHabilidad(@PathVariable Long id ){
        habilidadService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
