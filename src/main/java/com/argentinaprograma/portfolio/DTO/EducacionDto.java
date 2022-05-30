package com.argentinaprograma.portfolio.DTO;

import com.argentinaprograma.portfolio.Model.Persona;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class EducacionDto {
    private Long idEd;
    private String institucion;
    private String inicio;
    private String fin;
    private String titulo;
    private String ubicacion;
    private String logo;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Persona persona;

    public Long getIdEd() {
        return idEd;
    }

    public void setIdEd(Long idEd) {
        this.idEd = idEd;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public EducacionDto() {
    }
}
