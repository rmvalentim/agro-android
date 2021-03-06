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

import br.com.rafaelvalentim.agro.Model.Boletim;
import br.com.rafaelvalentim.agro.WebService.HttpGETService;
import br.com.rafaelvalentim.agro.WebService.HttpPOSTService;

public class BoletimService {

    public SpinnerAdapter getBoletimAdapter(Context context) {
        try {
            // Define a URL que será requisitada no serviço
            URL url = new URL(UrlBaseService.getUrl() + "boletins");
            // Realiza a requisição e recebe um Json
            String retorno = new HttpGETService(url).execute().get();
            // Lista de objetos que vai armazenar os resultados
            List<Boletim> list = new ArrayList<>();
            // Cria o Gson e popula a lista com objetos obtidos via servico
            Gson gson = new Gson();
            TypeToken<List<Boletim>> token = new TypeToken<List<Boletim>>() {};
            list = gson.fromJson(retorno, token.getType());

            // Cria um adapter para a ListView da Activity
            SpinnerAdapter adapter = new ArrayAdapter<Boletim>(context,
                    android.R.layout.simple_spinner_item,list);

            // Seta o adapter criado na ListView (Exibe o resultado)
            return adapter;

        } catch (InterruptedException | ExecutionException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String setBoletim(String json) {
        String retorno = "";
        try {
            URL url = new URL(UrlBaseService.getUrl() + "boletim");

            HttpPOSTService post = new HttpPOSTService(url);

            retorno = post.execute(json).get();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return retorno;
    }
}
