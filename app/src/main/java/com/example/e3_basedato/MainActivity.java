package com.example.e3_basedato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_alumnos",null,1);
    }
    public void onClick(View view){
        Intent miIntent = null;
        switch (view.getId()){
            case R.id.bnt_RegistroAlumno:
                miIntent=new Intent(MainActivity.this,RegistroAlumnoActivity.class);
                break;
            case R.id.bnt_ConsultaAlmuno:
                miIntent=new Intent(MainActivity.this,ConsultaAlumnoActivity.class);
                break;
            case R.id.bnt_ListaAlmuno:
                miIntent=new Intent(MainActivity.this,ListViewActivity.class);
                break;

        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }
}

