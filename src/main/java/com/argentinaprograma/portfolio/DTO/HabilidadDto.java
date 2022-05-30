package com.argentinaprograma.portfolio.DTO;

import com.argentinaprograma.portfolio.Model.Persona;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class HabilidadDto {
    private Long idHab;

    private String habilidad;

    private String logo;

    private String porcentaje;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Persona persona;

    public Long getIdHab() {
        return idHab;
    }

    public void setIdHab(Long idHab) {
        this.idHab = idHab;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public HabilidadDto() {
    }
}
