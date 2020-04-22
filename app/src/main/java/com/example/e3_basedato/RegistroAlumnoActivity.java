package com.example.e3_basedato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroAlumnoActivity extends AppCompatActivity {
    EditText campoId;
    EditText campoNombre;
    EditText campoCiudadNacimiento;
    EditText campoMatricula;
    EditText campoExpresionCreativa;
    // campoFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alumno);

        campoId = (EditText)findViewById(R.id.campoId);
        campoNombre = (EditText)findViewById(R.id.campoNombre);
        campoCiudadNacimiento = (EditText)findViewById(R.id.campoCiudadNacimiento);
        campoMatricula = (EditText)findViewById(R.id.campoMatricula);
        campoExpresionCreativa = (EditText)findViewById(R.id.campoExprescionCreativa);
        //campoFoto = (Button)findViewById(R.id.btnFoto);


    }
    public void onClick(View view){
        registrarAlumnos();
    }

    private void registrarAlumnos() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_alumnos",null,1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_CIUDAD_NAC,campoCiudadNacimiento.getText().toString());
        values.put(Utilidades.CAMPO_MATRICULA,campoMatricula.getText().toString());
        values.put(Utilidades.CAMPO_EXP_CREATIVA,campoExpresionCreativa.getText().toString());
        //values.put(.e3_sqlite.Utilidades.Utilidades.CAMPO_ID, String.valueOf(campoFoto.getBackground()));

        Long idResultante = db.insert(Utilidades.TABLA_ALUMNO,Utilidades.CAMPO_ID,values);

        Toast.makeText(getApplicationContext(), "Id Registro: "+idResultante+" con exito!", Toast.LENGTH_SHORT).show();
        db.close();
    }
}
