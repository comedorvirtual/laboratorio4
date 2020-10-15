package com.example.practica4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    ArrayList<String> nombres=new ArrayList<String>();
    ArrayList<String> cuis= new ArrayList<String>();
    Button registrar;
    private final int COD_ENVIO = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registrar = findViewById(R.id.registrar);
        lista = findViewById(R.id.lista);
        nombres.add("David");
        cuis.add("456125");
        MyAdapter adapter = new MyAdapter(MainActivity.this, nombres, cuis);
        lista.setAdapter(adapter);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent, COD_ENVIO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            assert data != null;
            String nomb = data.getStringExtra("nomb");
            String cod = data.getStringExtra("cod");
            nombres.add(nomb);
            cuis.add(cod);
            MyAdapter adapter = new MyAdapter(MainActivity.this, nombres, cuis);
            lista.setAdapter(adapter);
            Toast.makeText(this, nomb, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Registro Cancelado", Toast.LENGTH_SHORT).show();
        }
    }
}