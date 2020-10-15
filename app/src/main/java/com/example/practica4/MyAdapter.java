package com.example.practica4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> rnombre;
    ArrayList<String> rcui;

    public MyAdapter(@NonNull Context context, ArrayList<String> nombre, ArrayList<String> cui) {
        super(context, R.layout.content, R.id.nombreLista, nombre);
        this.context = context;
        this.rnombre=nombre;
        this.rcui=cui;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View content = layoutInflater.inflate(R.layout.content,parent, false);
        TextView nombre = content.findViewById(R.id.nombreLista);
        TextView cui = content.findViewById(R.id.cuiLista);

        nombre.setText(rnombre.get(position));
        cui.setText(rcui.get(position));
        return content;
    }
}
