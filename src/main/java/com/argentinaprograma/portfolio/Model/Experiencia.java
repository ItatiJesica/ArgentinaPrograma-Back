package com.argentinaprograma.portfolio.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="experiencia")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExp;

    @Column(name="empresa",nullable = false)
    private String empresa;

    @Column(name="inicio",nullable = false)
    private String inicio;

    @Column(name="fin",nullable = false)
    private String fin;

    @Column(name="tipo",nullable = false)
    private String tipo;

    @Column(name="ubicacion",nullable = false)
    private String ubicacion;

    @Column(name="puesto",nullable = false)
    private String puesto;

    @Column(name="logo",nullable = false)
    private String logo;

    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "persona_id")
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

    public Experiencia() {
    }

    public Experiencia(Long idExp, String empresa, String inicio, String fin, String tipo, String ubicacion, String puesto, String logo, Persona persona) {
        this.idExp = idExp;
        this.empresa = empresa;
        this.inicio = inicio;
        this.fin = fin;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.puesto = puesto;
        this.logo = logo;
        this.persona = persona;
    }
}
