package com.argentinaprograma.portfolio.Service;

import com.argentinaprograma.portfolio.DTO.ExperienciaDto;
import com.argentinaprograma.portfolio.DTO.ProyectoDto;

import java.util.List;

public interface ProyectoService {
    ProyectoDto save(ProyectoDto proyectoDto);
    ProyectoDto findById(Long id);
    List<ProyectoDto> findAll();
    void delete(Long id);
}
