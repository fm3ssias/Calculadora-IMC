package com.m3.fmessias.calculadoraimc;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListaDeReferenciaActivity extends Activity {

    private String[] arrayReferencias;

    private ListView listaReferencias;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_referencia);

        listaReferencias = findViewById(R.id.listReferencia);
        arrayReferencias = getResources().getStringArray(R.array.arrayReferencias);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayReferencias);

        listaReferencias.setAdapter(adapter);



    }

}
