package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText nombres;
    EditText cui;
    Button aceptar;
    Button cancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombres = findViewById(R.id.rNombres);
        cui = findViewById(R.id.rCui);
        aceptar = findViewById(R.id.aceptar);
        cancelar = findViewById(R.id.cancelar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean estado = comprobar(nombres,cui);
                if(estado){
                    String nomb = nombres.getText().toString();
                    String cod = cui.getText().toString();
                    Intent intent = getIntent();
                    intent.putExtra("nomb", nomb);
                    intent.putExtra("cod", cod);
                    setResult(RESULT_OK,intent);
                    finish();
                }

            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    public boolean comprobar(EditText nombre, EditText cui){
        if( nombre.getText().toString().isEmpty() || cui.getText().toString().isEmpty()){
            Toast toast = Toast.makeText(getApplicationContext(), "Falta llenar Datos", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        return true;

    }
}