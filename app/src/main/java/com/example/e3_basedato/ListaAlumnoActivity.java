package com.example.e3_basedato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class ListaAlumnoActivity extends AppCompatActivity {

    ArrayList<Alumno> listaAlumno;
    RecyclerView recyclerViewAlumno;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alumno);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_alumnos",null,1);

        listaAlumno=new ArrayList<>();

        recyclerViewAlumno= (RecyclerView)findViewById(R.id.recyclerAlumno);
        recyclerViewAlumno.setLayoutManager(new LinearLayoutManager(this));

        consultarListaAlumno();

        ListaAlumnoAdapter adapter=new ListaAlumnoAdapter(listaAlumno);
        recyclerViewAlumno.setAdapter(adapter);
    }

    private void consultarListaAlumno() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Alumno alumno=null;
        // listaAlumnos=new ArrayList<Alumno>();
        //select * from Alumnos
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_ALUMNO,null);

        while (cursor.moveToNext()){
            alumno=new Alumno();
            alumno.setId(cursor.getInt(0));
            alumno.setNombre(cursor.getString(1));
            alumno.setCiuNac(cursor.getString(2));
            alumno.setMat(cursor.getString(3));
            alumno.setExpCrea(cursor.getString(4));
            //Alumno.setImagen(cursor.getString(5));


            listaAlumno.add(alumno);
        }
    }

}
