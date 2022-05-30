package com.argentinaprograma.portfolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name="habilidad")
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHab;

    @Column(name="habilidad",nullable = false)
    private String habilidad;

    @Column(name="logo",nullable = false)
    private String logo;

    @Column(name="porcentaje",nullable = false)
    private String porcentaje;

    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "persona_id")
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

    public Habilidad() {
    }

    public Habilidad(Long idHab, String habilidad, String logo, String porcentaje, Persona persona) {
        this.idHab = idHab;
        this.habilidad = habilidad;
        this.logo = logo;
        this.porcentaje = porcentaje;
        this.persona = persona;
    }
}
