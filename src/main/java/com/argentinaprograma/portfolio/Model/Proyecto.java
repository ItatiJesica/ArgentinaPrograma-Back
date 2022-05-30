package com.argentinaprograma.portfolio.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPro;

    @Column(name="descripcion",nullable = false)
    private String descripcion;

    @Column(name="logo",nullable = false)
    private String logo;

    @Column(name="nombre",nullable = false)
    private String nombre;

    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "persona_id")
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

    public Proyecto() {
    }

    public Proyecto(Long idPro, String descripcion, String logo, String nombre, Persona persona) {
        this.idPro = idPro;
        this.descripcion = descripcion;
        this.logo = logo;
        this.nombre = nombre;
        this.persona = persona;
    }
}
