package com.example.androidonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidonline.utiles.Post;

import org.json.JSONArray;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    // Elementos de pantalla
    private Button miBotonA;
    private Button miBotonB;
    private Button miBotonC;
    private Button miBotonD;
    private Button miBotonE;
    private Button miBotonF;
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();

        miBotonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Boton A", Toast.LENGTH_SHORT).show();
            }
        });
        miBotonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Boton B", Toast.LENGTH_SHORT).show();
            }
        });
        miBotonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Boton C", Toast.LENGTH_SHORT).show();
            }
        });
        miBotonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Boton D", Toast.LENGTH_SHORT).show();
            }
        });
        miBotonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Boton E", Toast.LENGTH_SHORT).show();
            }
        });
        miBotonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Boton F", Toast.LENGTH_SHORT).show();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // En este punto lanzaremos el AsyncTask
                String resultado = edtEmail.getText().toString()
                        + "-" + edtPassword.getText().toString();
                Toast.makeText(MainActivity.this, "Datos:"
                        + resultado, Toast.LENGTH_SHORT).show();

                // Pasos para lanzar la tarea en segundo plano y conectar con el servidor web
                // URL: http://pruebascurso666.000webhostapp.com/loginGroupon.php
                // Parámetros: Usuario=a@svalero.com, Contrasena=1234

                HashMap<String, String> parametros = new HashMap<String, String>();
                parametros.put("Usuario",edtEmail.getText().toString());
                parametros.put("Contrasena",edtPassword.getText().toString() );

                TareaSegundoPlano tarea = new TareaSegundoPlano(parametros);
                tarea.execute("http://192.168.1.163:8888/justeat/loginGroupon.php");
            }
        });
    }

    private void inicializarComponentes() {
        miBotonA = (Button)findViewById(R.id.btnA);
        miBotonB = (Button)findViewById(R.id.btnB);
        miBotonC = (Button)findViewById(R.id.btnC);
        miBotonD = (Button)findViewById(R.id.btnD);
        miBotonE = (Button)findViewById(R.id.btnE);
        miBotonF = (Button)findViewById(R.id.btnF);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
    }

    // Hilo AsyncTask

    class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {

        private HashMap<String, String> parametros = null;
        //private ArrayList<Cliente> listaClientes = null;


        public TareaSegundoPlano( HashMap<String, String> parametros) {
            this.parametros = parametros;
        }


        @Override
        protected Boolean  doInBackground(String... params) {
            String url_select = params[0];
            try {
                Post post = new Post();
                JSONArray result = post.getServerDataPost(parametros,url_select);
                //listaClientes = Cliente.getArrayListFromJSon(result);
            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
                //messageUser = "Error al conectar con el servidor. ";
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean resp) {
            try {

            }catch (Exception e) {
                // TODO: handle exception
                Log.e("log_tag", "Error parsing data "+e.toString());
            }
        }
    }
}
