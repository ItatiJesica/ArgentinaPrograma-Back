package com.argentinaprograma.portfolio.Service;


import com.argentinaprograma.portfolio.DTO.HabilidadDto;

import java.util.List;

public interface HabilidadService {
    HabilidadDto save(HabilidadDto habilidadDto);
    HabilidadDto findById(Long id);
    List<HabilidadDto> findAll();
    void delete(Long id);
}
