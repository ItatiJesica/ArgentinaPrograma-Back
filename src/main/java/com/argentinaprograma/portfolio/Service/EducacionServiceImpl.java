package com.argentinaprograma.portfolio.Service;

import com.argentinaprograma.portfolio.DTO.EducacionDto;
import com.argentinaprograma.portfolio.Model.Educacion;
import com.argentinaprograma.portfolio.Repository.EducacionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducacionServiceImpl implements EducacionService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EducacionRepository educacionRepository;

    @Override
    public EducacionDto save(EducacionDto educacionDto) {
        Educacion educacion =mapearEntity(educacionDto);
        Educacion nuevaEducacion = educacionRepository.save(educacion);
        return mapearDto(nuevaEducacion);
    }

    @Override
    public EducacionDto findById(Long id) {
        Educacion educacion= educacionRepository.findById(id).orElse(null);
        return mapearDto(educacion);
    }

    @Override
    public List<EducacionDto> findAll() {
        List<Educacion> educaciones= educacionRepository.findAll();
        return educaciones.stream().map(educacion-> mapearDto(educacion)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        educacionRepository.deleteById(id);
    }

    //convierte entidad a dto
    private EducacionDto mapearDto(Educacion educacion){
        EducacionDto educacionDto= modelMapper.map(educacion, EducacionDto.class);
        return educacionDto;
    }

    //Convertimos de DTO a Entidad
    private Educacion mapearEntity(EducacionDto educacionDto){
        Educacion educacion= modelMapper.map(educacionDto, Educacion.class);
        return educacion;
    }
}
