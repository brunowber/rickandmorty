package service;

import android.content.Context;
import android.os.AsyncTask;
import android.app.ProgressDialog;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

import model.Personagem;

public class RickAndMortyService extends AsyncTask<Void, Void, Personagem> {

    private final String id;
    private ProgressDialog dialog;
    private Context context;

    public RickAndMortyService(String id, Context context) {
        this.id = id;
        this.context = context;

    }
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(context);
        dialog.setTitle("Consultando a API");
        dialog.setMessage("Aguarde a consulta dos dados...");
        dialog.show();
    }

    @Override
    protected Personagem doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL("https://rickandmortyapi.com/api/character/"+this.id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();
            Scanner scanner = new Scanner((url.openStream()));
            while (scanner.hasNext()) {
                resposta.append(scanner.next());
            }

        } catch (MalformedURLException e) {
            return null;
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.dismiss();
        return new Gson().fromJson(resposta.toString(), Personagem.class);
    }

}
