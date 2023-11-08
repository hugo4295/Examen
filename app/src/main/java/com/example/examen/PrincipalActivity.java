package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {

    EditText texto;
    Button boton;
    private TextView etiqueta;

    public static String enviatexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        texto = findViewById(R.id.editTextText);
        boton = findViewById(R.id.button);
        etiqueta = findViewById(R.id.textView);

        boton.setOnClickListener(v -> {
            enviatexto=texto.getText().toString();
            Intent servicio = new Intent(this,Miservicio.class);
            startService(servicio);
        });
        Miservicio.ACTUALIZA_ESCUCHA(this);
    }

    public void actualizatexto(String cadena){
        etiqueta.setText(cadena);
    }
}