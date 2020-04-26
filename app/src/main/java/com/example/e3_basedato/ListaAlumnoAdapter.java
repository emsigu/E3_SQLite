package com.example.e3_basedato;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAlumnoAdapter extends RecyclerView.Adapter<ListaAlumnoAdapter.AlumnoViewHolder> {

    ArrayList<Alumno> listaAlumno;

    public ListaAlumnoAdapter(ArrayList<Alumno> listaAlumno) {
        this.listaAlumno = listaAlumno;
    }

    @Override
    public AlumnoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_alumno,null,false);
        return new AlumnoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlumnoViewHolder holder, int position) {
        holder.documento.setText(listaAlumno.get(position).getId().toString());
        holder.nombre.setText(listaAlumno.get(position).getNombre());
        holder.ciuNac.setText(listaAlumno.get(position).getCiuNac());
        holder.mat.setText(listaAlumno.get(position).getMat());
        holder.expCrea.setText(listaAlumno.get(position).getExpCrea());
        //holder.imagen.setText(listaAlumno.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return listaAlumno.size();
    }

    public class AlumnoViewHolder extends RecyclerView.ViewHolder {

        TextView documento,nombre,ciuNac,mat,expCrea,imagen;

        public AlumnoViewHolder(View itemView) {
            super(itemView);
            documento = (TextView) itemView.findViewById(R.id.campoId);
            nombre = (TextView) itemView.findViewById(R.id.campoNombre);
            ciuNac = (TextView) itemView.findViewById(R.id.campoCiudadNacimiento);
            mat = (TextView) itemView.findViewById(R.id.campoMatricula);
            expCrea = (TextView) itemView.findViewById(R.id.campoExprescionCreativa);
            //imagen = (TextView) itemView.findViewById(R.id.imageView);
        }
    }
}
