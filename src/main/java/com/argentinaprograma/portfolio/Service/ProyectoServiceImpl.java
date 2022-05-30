package com.argentinaprograma.portfolio.Service;


import com.argentinaprograma.portfolio.DTO.ProyectoDto;
import com.argentinaprograma.portfolio.Model.Proyecto;
import com.argentinaprograma.portfolio.Repository.ProyectoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProyectoServiceImpl implements ProyectoService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public ProyectoDto save(ProyectoDto proyectoDto) {
        Proyecto proyecto =mapearEntity(proyectoDto);
        Proyecto nuevoProyecto = proyectoRepository.save(proyecto);
        return mapearDto(nuevoProyecto);
    }

    @Override
    public ProyectoDto findById(Long id) {
        Proyecto proyecto= proyectoRepository.findById(id).orElse(null);
        return mapearDto(proyecto);
    }

    @Override
    public List<ProyectoDto> findAll() {
        List<Proyecto> proyectos= proyectoRepository.findAll();
        return proyectos.stream().map(proyecto -> mapearDto(proyecto)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        proyectoRepository.deleteById(id);
    }
    //convierte entidad a dto
    private ProyectoDto mapearDto(Proyecto proyecto){
        ProyectoDto proyectoDto = modelMapper.map(proyecto, ProyectoDto.class);
        return proyectoDto;
    }

    //Convertimos de DTO a Entidad
    private Proyecto mapearEntity(ProyectoDto proyectoDto){
        Proyecto proyecto= modelMapper.map(proyectoDto, Proyecto.class);
        return proyecto;
    }
}
