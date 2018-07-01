package com.example.brunoweber.rickandmorty;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class showData  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        final TextView resposta = findViewById(R.id.tv__resposta);
        String s = getIntent().getStringExtra("retorno");
        resposta.setText(s.toString());
    }

}
