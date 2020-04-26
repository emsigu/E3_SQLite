package com.example.e3_basedato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultaAlumnoActivity extends AppCompatActivity {

    TextView campoId;
    TextView campoNombre;
    TextView campoCiudadNacimiento;
    TextView campoMatricula;
    TextView campoExpresionCreativa;
    ImageView campoFoto;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_alumno);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_alumnos",null,1);

        campoId = (TextView) findViewById(R.id.documentoId);
        campoNombre = (TextView) findViewById(R.id.campoNombreConsulta);
        campoCiudadNacimiento = (TextView) findViewById(R.id.campoCiudadNacimientoConsulta);
        campoMatricula = (TextView) findViewById(R.id.campoMatriculaConsulta);
        campoExpresionCreativa = (TextView) findViewById(R.id.campoExprescionCreativaConsulta);
        campoFoto = (ImageView) findViewById(R.id.imageConsulta);

    }
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnConsultar: consultar();
                break;
            case R.id.btnActualizar: actualizarAlumno();
                break;
            case R.id.btnEliminar: eliminarAlumno();
                break;
        }

    }
    private void eliminarAlumno() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};

        db.delete(Utilidades.TABLA_ALUMNO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó el alumno",Toast.LENGTH_LONG).show();
        campoId.setText("");
        limpiar();
        db.close();
    }
    private void actualizarAlumno() {
        SQLiteDatabase db=conn.getWritableDatabase();

        String[] parametros={campoId.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_CIUDAD_NAC,campoCiudadNacimiento.getText().toString());
        values.put(Utilidades.CAMPO_MATRICULA,campoMatricula.getText().toString());
        values.put(Utilidades.CAMPO_EXP_CREATIVA,campoExpresionCreativa.getText().toString());
        //values.put(Utilidades.CAMPO_FOTO,campoFoto.getText().toString());

        db.update(Utilidades.TABLA_ALUMNO,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó el alumno",Toast.LENGTH_LONG).show();
        db.close();

    }

    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};
        String[] campos={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_CIUDAD_NAC,Utilidades.CAMPO_MATRICULA,Utilidades.CAMPO_EXP_CREATIVA};

        try {
            Cursor cursor =db.query(Utilidades.TABLA_ALUMNO,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null,null);
            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoCiudadNacimiento.setText(cursor.getString(1));
            campoMatricula.setText(cursor.getString(2));
            campoExpresionCreativa.setText(cursor.getString(3));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El registro no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }


    }
    public void limpiar() {
        campoNombre.setText("");
        campoCiudadNacimiento.setText("");
        campoMatricula.setText("");
        campoExpresionCreativa.setText("");

    }

}
