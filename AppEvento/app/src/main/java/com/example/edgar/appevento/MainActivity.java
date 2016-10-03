package com.example.edgar.appevento;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ItemVideoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cria lista no contexto java seguindo modelo layout do resource
        ListView lista = (ListView) findViewById(R.id.lista);

        // cria e seta um adapter array conforme modelo default android simple_list_1
        adapter = new ItemVideoAdapter(this,new ArrayList<ItemVideo>());
        lista.setAdapter(adapter);

        // seta lister para monitorar  clique em cada item da lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // sobrecreve metodo para executar ação ao clique
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetalheActivity.class);
                ItemVideo aula = (ItemVideo) parent.getItemAtPosition(position);
                intent.putExtra("AULA",aula);
                startActivity(intent);

            }
        });

        new EventoTask().execute();
    }
        class EventoTask extends AsyncTask<Void,Void,List<ItemVideo>>{


            @Override
            protected List<ItemVideo> doInBackground(Void... params) {
                HttpURLConnection urlConnection = null;
                BufferedReader reader= null;

                try{
                    URL url = new URL("http://private-d88f6f-semanadevandroid.apiary-mock.com/listar");
                    urlConnection = (HttpURLConnection)url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    InputStream inputStream = urlConnection.getInputStream();
                    String linha;
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuffer buffer = new StringBuffer();

                    while ((linha = reader.readLine()) != null){
                        buffer.append(linha);
                        buffer.append("\n");
                    }
                    return JSonUtil.fromJson(buffer.toString());


                }catch (Exception e){
                    if(urlConnection != null){
                        urlConnection.disconnect();
                        e.printStackTrace();
                    }
                    if(reader != null){
                        try {
                            reader.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(List<ItemVideo> itemVideos) {
                adapter.clear();
                adapter.addAll(itemVideos);
                adapter.notifyDataSetChanged();
            }
        }
}
