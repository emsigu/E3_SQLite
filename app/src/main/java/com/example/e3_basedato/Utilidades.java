package com.example.e3_basedato;

public class Utilidades {

    //Constantes campos tabla alumno
    public static final String TABLA_ALUMNO ="alumnos";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_CIUDAD_NAC = "ciudadNacimiento";
    public static final String CAMPO_MATRICULA = "matricula";
    public static final String CAMPO_EXP_CREATIVA = "expresionCreativa";
    public static final String CAMPO_FOTO = "foto";


    public static final String CREAR_TABLA_ALUMNO= "CREATE TABLE "+TABLA_ALUMNO+" ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_CIUDAD_NAC+" TEXT, "+CAMPO_MATRICULA+" TEXT, "+CAMPO_EXP_CREATIVA+" TEXT, "+CAMPO_FOTO+" TEXT)";



}
