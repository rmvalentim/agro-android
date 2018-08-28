package br.com.rafaelvalentim.agro.Service;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.rafaelvalentim.agro.Model.Cultura;
import br.com.rafaelvalentim.agro.WebService.HttpGETService;

public class CulturaService {

    public SpinnerAdapter getCulturaAdapter(Context context) {
        try {
            // Define a URL que será requisitada no serviço
            URL url = new URL("http://192.168.0.156:8080/api/culturas");
            // Realiza a requisição e recebe um Json
            String retorno = new HttpGETService(url).execute().get();
            // Lista de objetos que vai armazenar os resultados
            List<Cultura> list = new ArrayList<>();
            // Cria o Gson e popula a lista com objetos obtidos via servico
            Gson gson = new Gson();
            TypeToken<List<Cultura>> token = new TypeToken<List<Cultura>>() {};
            list = gson.fromJson(retorno, token.getType());

            // Cria um adapter para a ListView da Activity
            SpinnerAdapter adapter = new ArrayAdapter<Cultura>(context,
                    android.R.layout.simple_spinner_item,list);

            // Seta o adapter criado na ListView (Exibe o resultado)
            return adapter;

        } catch (InterruptedException | ExecutionException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
