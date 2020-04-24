package com.example.e3_basedato;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleAlumnoActivity extends AppCompatActivity {
    TextView campoId;
    TextView campoNombre;
    TextView campoCiudadNacimiento;
    TextView campoMatricula;
    TextView campoExpresionCreativa;
    //ImageView campoFoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_alumno);

        campoId = (TextView) findViewById(R.id.campoId);
        campoNombre = (TextView) findViewById(R.id.campoNombre);
        campoCiudadNacimiento = (TextView) findViewById(R.id.campoCiudadNacimiento);
        campoMatricula = (TextView) findViewById(R.id.campoMatricula);
        campoExpresionCreativa = (TextView) findViewById(R.id.campoExprescionCreativa);
        campoMatricula = (TextView) findViewById(R.id.campoMatricula);
        //campoFoto = (ImageView) findViewById(R.id.IV_Foto);

        Bundle objetoEnviado=getIntent().getExtras();

        Alumno alumno = null;

        if(objetoEnviado!=null){
            alumno= (Alumno) objetoEnviado.getSerializable("alumno");
            campoId.setText(alumno.getId().toString());
            campoNombre.setText(alumno.getNombre().toString());
            campoCiudadNacimiento.setText(alumno.getCiuNac().toString());
            campoMatricula.setText(alumno.getMat().toString());
            campoExpresionCreativa.setText(alumno.getExpCrea().toString());
            //campoFoto.setImageBitmap(alumno.getImagen().toString());

        }

    }

}
