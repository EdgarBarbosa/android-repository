package com.example.edgar.appevento;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Intent intent = getIntent();
        final ItemVideo itemVideo = (ItemVideo)intent.getSerializableExtra("AULA");


        TextView titulo = (TextView) findViewById(R.id.titulo);
        titulo.setText(itemVideo.getTitulo());

        TextView data = (TextView) findViewById(R.id.data);

        Button button = (Button) findViewById(R.id.botaoUrl);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(itemVideo.getUrl()));
                startActivity(intent);
            }
        });
    }
}
