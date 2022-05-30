package com.argentinaprograma.portfolio.Service;

import com.argentinaprograma.portfolio.DTO.PersonaDto;
import com.argentinaprograma.portfolio.Model.Experiencia;
import com.argentinaprograma.portfolio.Model.Persona;
import com.argentinaprograma.portfolio.Repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public PersonaDto save(PersonaDto personaDto) {
        Persona persona =mapearEntity(personaDto);
        Persona nuevaPersona = personaRepository.save(persona);
        return mapearDto(nuevaPersona);
    }

    @Override
    public PersonaDto findById(Long id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        return mapearDto(persona);
    }

    @Override
    public List<PersonaDto> findAll() {
        List<Persona> personas= personaRepository.findAll();
        return personas.stream().map(persona -> mapearDto(persona)).collect(Collectors.toList());
    }

    //convierte entidad a dto
    private PersonaDto mapearDto(Persona persona){
        PersonaDto personaDto= modelMapper.map(persona, PersonaDto.class);
        return personaDto;

    }

    //Convertimos de DTO a Entidad
    private Persona mapearEntity(PersonaDto personaDto){
        Persona persona =  modelMapper.map(personaDto, Persona.class);
        return persona;
    }
}
