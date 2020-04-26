package com.example.e3_basedato;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Alumno implements Serializable {

    private Integer id;
    private String nombre;
    private String ciuNac;
    private String mat;
    private String expCrea;
    private Bitmap image;

    public Alumno( Integer id, String nombre, String ciuNac, String mat, String expCrea,Bitmap image){
        this.id = id;
        this.nombre = nombre;
        this.ciuNac = ciuNac;
        this.mat = mat;
        this.expCrea = expCrea;

        this.image = image;
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


    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
