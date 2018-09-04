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

import br.com.rafaelvalentim.agro.Model.Produto;
import br.com.rafaelvalentim.agro.WebService.HttpGETService;

public class ProdutoService {

    public SpinnerAdapter getProdutoAdapter(Context context) {
        try {
            // Define a URL que será requisitada no serviço
            URL url = new URL(UrlBaseService.getUrl() + "produtos");
            // Realiza a requisição e recebe um Json
            String retorno = new HttpGETService(url).execute().get();
            // Lista de objetos que vai armazenar os resultados
            List<Produto> list = new ArrayList<>();
            // Cria o Gson e popula a lista com objetos obtidos via servico
            Gson gson = new Gson();
            TypeToken<List<Produto>> token = new TypeToken<List<Produto>>() {};
            list = gson.fromJson(retorno, token.getType());

            // Cria um adapter para a ListView da Activity
            SpinnerAdapter adapter = new ArrayAdapter<Produto>(context,
                    android.R.layout.simple_spinner_item,list);

            // Seta o adapter criado na ListView (Exibe o resultado)
            return adapter;

        } catch (InterruptedException | ExecutionException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
