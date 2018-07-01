package com.example.brunoweber.rickandmorty;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        btn_buscar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (person.getText().toString().trim().length() > 0) {
                    try {
                        Personagem retorno = new RickAndMortyService(person.getText().toString()).execute().get();
                        if (retorno != null) {
                            Intent i = new Intent(getBaseContext(), showData.class);
                            i.putExtra("retorno", retorno.toString());
                            startActivity(i);
                        }
                        else{
                            toast("Não foi encontrado nenhum personagem!");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    toast("Insira algum valor!");
                }
            }
        });
    }

    public void toast(String msg){

        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
