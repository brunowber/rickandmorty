package com.example.brunoweber.rickandmorty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import Model.Personagem;
import service.RickAndMortyService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_buscar = findViewById(R.id.btn_buscar);
        final EditText person = findViewById(R.id.editChar);
        final TextView resposta = findViewById(R.id.tv_resposta);

        btn_buscar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {;
                try {
                    Personagem retorno = new RickAndMortyService(person.getText().toString()).execute().get();
                    resposta.setText(retorno.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
