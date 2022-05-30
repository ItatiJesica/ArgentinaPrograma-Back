package com.argentinaprograma.portfolio.Model;

import javax.persistence.*;


@Entity
@Table(name="personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre",nullable = false)
    private String nombre;

    @Column(name="contacto",nullable = false)
    private String contacto;

    @Column(name="descripcion",nullable = false)
    private String descripcion;

    @Column(name="foto",nullable = false)
    private String foto;

    @Column(name="titulo",nullable = false)
    private String titulo;

    @Column(name="ubicacion",nullable = false)
    private String ubicacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public Persona() {
    }

    public Persona(Long id, String nombre, String contacto, String descripcion, String foto, String titulo, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.descripcion = descripcion;
        this.foto = foto;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
    }
}
