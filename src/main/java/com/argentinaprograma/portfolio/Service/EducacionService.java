package com.argentinaprograma.portfolio.Service;

import com.argentinaprograma.portfolio.DTO.EducacionDto;

import java.util.List;

public interface EducacionService {
    EducacionDto save(EducacionDto educacionDto);
    EducacionDto findById(Long id);
    List<EducacionDto> findAll();
    void delete(Long id);
}
