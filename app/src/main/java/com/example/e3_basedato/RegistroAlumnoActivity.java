package com.example.e3_basedato;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;


public class RegistroAlumnoActivity extends AppCompatActivity {


    private ImageView objectImageView;

    private static final int PICK_IMAGE_REQUEST=100;
    private Uri imageFilePath;


    private Bitmap imageToStore;
    ConexionSQLiteHelper objectDatabaseHandler;


    EditText campoId;
    EditText campoNombre;
    EditText campoCiudadNacimiento;
    EditText campoMatricula;
    EditText campoExpresionCreativa;



    Alumno objectModelClass;
    private ByteArrayOutputStream objectByteArrayOutputStream;
    private byte[] imageInBytes;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alumno);
        this.context=context;


        campoId = (EditText)findViewById(R.id.campoId);
        campoNombre = (EditText)findViewById(R.id.campoNombre);
        campoCiudadNacimiento = (EditText)findViewById(R.id.campoCiudadNacimiento);
        campoMatricula = (EditText)findViewById(R.id.campoMatricula);
        campoExpresionCreativa = (EditText)findViewById(R.id.campoExprescionCreativa);


        try{

            objectImageView=(ImageView) findViewById(R.id.imageIV);

        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

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

        limpiar();
    }
    public void limpiar() {
        campoNombre.setText("");
        campoCiudadNacimiento.setText("");
        campoMatricula.setText("");
        campoExpresionCreativa.setText("");
        //objectImageView.setImageDrawable(null);
    }
    public void chooseImage(View objectView)
    {
        try{
            Intent objectIntent = new Intent();
            objectIntent.setType("image/*");

            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent,PICK_IMAGE_REQUEST);

        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        try {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null)
            {
                imageFilePath=data.getData();
                imageToStore= MediaStore.Images.Media.getBitmap(getContentResolver(),imageFilePath);

                objectImageView.setImageBitmap(imageToStore);
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }



}
