package com.argentinaprograma.portfolio.DTO;

import com.argentinaprograma.portfolio.Model.Persona;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class ProyectoDto {
    private Long idPro;

    private String descripcion;

    private String logo;

    private String nombre;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Persona persona;

    public Long getIdPro() {
        return idPro;
    }

    public void setIdPro(Long idPro) {
        this.idPro = idPro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ProyectoDto() {
    }
}
