package com.argentinaprograma.portfolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="educacion")
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEd;

    @Column(name="institucion",nullable = false)
    private String institucion;

    @Column(name="inicio",nullable = false)
    private String inicio;

    @Column(name="fin",nullable = false)
    private String fin;

    @Column(name="titulo",nullable = false)
    private String titulo;

    @Column(name="ubicacion",nullable = false)
    private String ubicacion;

    @Column(name="logo",nullable = false)
    private String logo;

    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "persona_id")
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

    public Educacion() {
    }

    public Educacion(Long idEd, String institucion, String inicio, String fin, String titulo, String ubicacion, String logo, Persona persona) {
        this.idEd = idEd;
        this.institucion = institucion;
        this.inicio = inicio;
        this.fin = fin;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.logo = logo;
        this.persona = persona;
    }
}
