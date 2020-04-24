package com.example.e3_basedato;

import java.io.Serializable;

public class Alumno implements Serializable {

    private Integer id;
    private String nombre;
    private String ciuNac;
    private String mat;
    private String expCrea;
    private String imagen;

    public Alumno( Integer id, String nombre, String ciuNac, String mat, String expCrea, String imagen){
        this.id = id;
        this.nombre = nombre;
        this.ciuNac = ciuNac;
        this.mat = mat;
        this.expCrea = expCrea;
        this.imagen = imagen;
    }
    public Alumno()
    {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiuNac() {
        return ciuNac;
    }

    public void setCiuNac(String ciuNac) {
        this.ciuNac = ciuNac;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getExpCrea() {
        return expCrea;
    }

    public void setExpCrea(String expCrea) {
        this.expCrea = expCrea;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
