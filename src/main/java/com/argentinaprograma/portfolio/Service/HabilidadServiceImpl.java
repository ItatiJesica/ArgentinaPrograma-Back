package com.argentinaprograma.portfolio.Service;


import com.argentinaprograma.portfolio.DTO.HabilidadDto;
import com.argentinaprograma.portfolio.Model.Experiencia;
import com.argentinaprograma.portfolio.Model.Habilidad;
import com.argentinaprograma.portfolio.Repository.HabilidadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabilidadServiceImpl implements HabilidadService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HabilidadRepository habilidadRepository;

    @Override
    public HabilidadDto save(HabilidadDto habilidadDto) {
        Habilidad habilidad =mapearEntity(habilidadDto);
        Habilidad nuevaHabilidad = habilidadRepository.save(habilidad);
        return mapearDto(nuevaHabilidad);
    }

    @Override
    public HabilidadDto findById(Long id) {
        Habilidad habilidad= habilidadRepository.findById(id).orElse(null);
        return mapearDto(habilidad);
    }

    @Override
    public List<HabilidadDto> findAll() {
        List<Habilidad> habilidades= habilidadRepository.findAll();
        return habilidades.stream().map(habilidad -> mapearDto(habilidad)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        habilidadRepository.deleteById(id);
    }
    //convierte entidad a dto
    private HabilidadDto mapearDto(Habilidad habilidad){
        HabilidadDto habilidadDto = modelMapper.map(habilidad, HabilidadDto.class);
        return habilidadDto;
    }

    //Convertimos de DTO a Entidad
    private Habilidad mapearEntity(HabilidadDto habilidadDto){
        Habilidad habilidad= modelMapper.map(habilidadDto, Habilidad.class);
        return habilidad;
    }
}
