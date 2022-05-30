package com.argentinaprograma.portfolio.Service;


import com.argentinaprograma.portfolio.DTO.PersonaDto;
import java.util.List;

public interface PersonaService {
    public PersonaDto save(PersonaDto personaDto);
    public PersonaDto findById(Long id);
    public List<PersonaDto> findAll();
}
