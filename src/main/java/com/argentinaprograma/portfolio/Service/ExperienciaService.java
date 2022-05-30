package com.argentinaprograma.portfolio.Service;

import com.argentinaprograma.portfolio.DTO.ExperienciaDto;

import java.util.List;

public interface ExperienciaService {
    ExperienciaDto save(ExperienciaDto experienciaDto);
    ExperienciaDto findById(Long id);
    List<ExperienciaDto> findAll();
    void delete(Long id);
}
