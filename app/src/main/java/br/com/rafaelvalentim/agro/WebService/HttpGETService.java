package br.com.rafaelvalentim.agro.WebService;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

// Recebe uma URL, faz uma requisição HTTP com o método GET e retorna um JSON
public class HttpGETService extends AsyncTask<Void, Void, String> {

    private final URL url;

    public HttpGETService(URL url){
        this.url = url;
    }

    @Override
    protected String doInBackground(Void... voids) {
        // StringBuilder onde irá ser construido o retorno
        StringBuilder resposta = new StringBuilder();

            try {
                // Cria uma Conexão HTTP
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                // Seta o método usado na requisição
                connection.setRequestMethod("GET");
                // Define a utilização do formato Json
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);
                // Realiza a conexão
                connection.connect();

                // Scanner que irá ler os dados de retorno da requisição HTTP
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()){
                    resposta.append(scanner.useDelimiter("\\A").next());
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        // Retorna a resposta no formato Json
        return resposta.toString();
    }
}
