package com.example.androidonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Lista extends AppCompatActivity {

    private ListView listaPeliculas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_peliculas);

        initComponentes();

    }

    private void initComponentes() {
        listaPeliculas = findViewById(R.id.lstPeliculas);
    }
}
