package com.example.androidonline.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidonline.R;
import com.example.androidonline.beans.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPeliculas extends ArrayAdapter<Pelicula> {
    private Context context;
    private ArrayList<Pelicula> lstPeliculas;

    public AdaptadorPeliculas(Context context, ArrayList<Pelicula> lstPeliculas) {
        super(context, R.layout.item_fila, lstPeliculas);
        this.context = context;
        this.lstPeliculas = lstPeliculas;
    }

    @Override
    public View getView(int position, View filaVisual, ViewGroup parent) {
        Pelicula pelicula = lstPeliculas.get(position);
        if(filaVisual==null) {
            // primera vez que se contruye la fila
            filaVisual = LayoutInflater.from(context).inflate(R.layout.item_fila, null);
            ImageView imagen = filaVisual.findViewById(R.id.imgPelicula);
            TextView txtTitulo = filaVisual.findViewById(R.id.txtTitulo);
            TextView txtDescripcion = filaVisual.findViewById(R.id.txtDescripcion);
            //imagen.setImageDrawable();
            txtTitulo.setText(pelicula.getTitulo());
            txtDescripcion.setText(pelicula.getDescripcion());
        }
    }
}
