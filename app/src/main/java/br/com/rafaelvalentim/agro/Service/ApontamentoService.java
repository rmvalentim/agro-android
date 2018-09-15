package br.com.rafaelvalentim.agro.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import br.com.rafaelvalentim.agro.WebService.HttpPOSTService;

public class ApontamentoService {

    public String setApontamento(String json) {
        String retorno = "";
        try {
            URL url = new URL(UrlBaseService.getUrl() + "apontamento");

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
