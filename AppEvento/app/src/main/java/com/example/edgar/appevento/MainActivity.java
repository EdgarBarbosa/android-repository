package com.example.edgar.appevento;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //final String[] arrayAulas = getResources().getStringArray(R.array.arrayAulas);

        final ArrayList<ItemVideo> itemVideos = new ArrayList<>();
        itemVideos.add(new ItemVideo("Principais erros","26/09/2016","htttp://"));
        itemVideos.add(new ItemVideo("Video aula prática","28/09/2016","htttp://"));
        itemVideos.add(new ItemVideo("Video aula prática 2","29/09/2016","htttp://"));
        itemVideos.add(new ItemVideo("Dúvidas respondidas","30/09/2016","htttp://"));

        //cria lista no contexto java seguindo modelo layout do resource
        ListView lista = (ListView) findViewById(R.id.lista);

        // cria e seta um adapter array conforme modelo default android simple_list_1
        ItemVideoAdapter adapter = new ItemVideoAdapter(this,itemVideos);
        lista.setAdapter(adapter);

        // seta lister para monitorar  clique em cada item da lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // sobrecreve metodo para executar ação ao clique
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetalheActivity.class);
                ItemVideo aula = itemVideos.get(position);
                intent.putExtra("AULA",aula);
                startActivity(intent);

            }
        });


    }
}
