package com.argentinaprograma.portfolio.Service;

import com.argentinaprograma.portfolio.DTO.ExperienciaDto;
import com.argentinaprograma.portfolio.Model.Experiencia;
import com.argentinaprograma.portfolio.Repository.ExperienciaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienciaServiceImpl implements ExperienciaService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Override
    public ExperienciaDto save(ExperienciaDto experienciaDto) {
        Experiencia experiencia =mapearEntity(experienciaDto);
        Experiencia nuevaExperiencia = experienciaRepository.save(experiencia);
        return mapearDto(nuevaExperiencia);
    }

    @Override
    public ExperienciaDto findById(Long id) {
        Experiencia experiencia= experienciaRepository.findById(id).orElse(null);
        return mapearDto(experiencia);
    }

    @Override
    public List<ExperienciaDto> findAll() {
        List<Experiencia> experiencias= experienciaRepository.findAll();
        return experiencias.stream().map(experiencia -> mapearDto(experiencia)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        experienciaRepository.deleteById(id);
    }

    //convierte entidad a dto
    private ExperienciaDto mapearDto(Experiencia experiencia){
        ExperienciaDto experienciaDto = modelMapper.map(experiencia, ExperienciaDto.class);
        return experienciaDto;
    }

    //Convertimos de DTO a Entidad
    private Experiencia mapearEntity(ExperienciaDto experienciaDto){
        Experiencia experiencia= modelMapper.map(experienciaDto, Experiencia.class);
        return experiencia;
    }
}
