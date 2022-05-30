package com.argentinaprograma.portfolio.DTO;

import com.argentinaprograma.portfolio.Model.Persona;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ExperienciaDto {
    private Long idExp;

    private String empresa;

    private String inicio;

    private String fin;

    private String tipo;

    private String ubicacion;

    private String puesto;

    private String logo;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Persona persona;

    public Long getIdExp() {
        return idExp;
    }

    public void setIdExp(Long idExp) {
        this.idExp = idExp;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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

    public ExperienciaDto() {
    }
}
