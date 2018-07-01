package com.example.brunoweber.rickandmorty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import service.DownloadImageTask;

public class showData  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        final TextView resposta = findViewById(R.id.tv__resposta);
        String dados = getIntent().getStringExtra("retorno");
        String url = getIntent().getStringExtra("imagem");
        resposta.setText(dados.toString());

        new DownloadImageTask((ImageView) findViewById(R.id.img_foto))
                .execute(url.toString());
}

}
