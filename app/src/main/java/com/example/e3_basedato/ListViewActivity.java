package com.example.e3_basedato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView listViewAlumno;
    ArrayList<String> listaInformacion;
    ArrayList<Alumno> listaAlumno;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_alumnos",null,1);

        listViewAlumno= (ListView) findViewById(R.id.listViewAlumno);

        consultarListaAlumno();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewAlumno.setAdapter(adaptador);

        listViewAlumno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                String informacion="id: "+listaAlumno.get(pos).getId()+"\n";
                informacion+="Nombre: "+listaAlumno.get(pos).getNombre()+"\n";
                informacion+="CidudadNacimiento: "+listaAlumno.get(pos).getCiuNac()+"\n";
                informacion+="matricula: "+listaAlumno.get(pos).getMat()+"\n";
                informacion+="ExpresionCrea: "+listaAlumno.get(pos).getExpCrea()+"\n";


                Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).cancel();

                Alumno alumno=listaAlumno.get(pos);

                Intent intent=new Intent(ListViewActivity.this,DetalleAlumnoActivity.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("alumno",alumno);

                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


    }
    private void consultarListaAlumno() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Alumno alumno=null;
        listaAlumno=new ArrayList<Alumno>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_ALUMNO,null);

        while (cursor.moveToNext()){
            alumno=new Alumno();
            alumno.setId(cursor.getInt(0));
            alumno.setNombre(cursor.getString(1));
            alumno.setCiuNac(cursor.getString(2));
            alumno.setMat(cursor.getString(3));
            alumno.setExpCrea(cursor.getString(4));

            listaAlumno.add(alumno);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i=0; i<listaAlumno.size();i++){
            listaInformacion.add(listaAlumno.get(i).getId()+" - "
                    +listaAlumno.get(i).getNombre()+" - "+listaAlumno.get(i).getMat());
        }

    }
}
