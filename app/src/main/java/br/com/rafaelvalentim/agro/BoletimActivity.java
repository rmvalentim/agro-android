package br.com.rafaelvalentim.agro;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import br.com.rafaelvalentim.agro.Model.BoletimAPI;
import br.com.rafaelvalentim.agro.Service.BoletimService;
import br.com.rafaelvalentim.agro.Service.SafraService;
import br.com.rafaelvalentim.agro.Service.UnidadeProdutivaService;


public class BoletimActivity extends AppCompatActivity {

    Spinner spnUnidadeProdutiva;
    Spinner spnSafra;
    EditText edtObservacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boletim);

        spnUnidadeProdutiva = (Spinner) findViewById(R.id.unidade);
        spnSafra = (Spinner) findViewById(R.id.safra);
        edtObservacao = (EditText) findViewById(R.id.observacao);

        UnidadeProdutivaService unidadeService = new UnidadeProdutivaService();
        SafraService safraService = new SafraService();

        if(isOnline()){
            // Seta o adapter criado na ListView (Exibe o resultado)
            spnUnidadeProdutiva.setAdapter(unidadeService.getUnidadeProdutivaAdapter(getApplicationContext()));
            spnSafra.setAdapter(safraService.getSafraAdapter(getApplicationContext()));

        } else {
            Toast.makeText(this, "Sem conexão com a internet",Toast.LENGTH_SHORT).show();
        }

    }


    public void salvarBoletim(View view) {

        BoletimAPI boletim = new BoletimAPI();

        boletim.setUnidadeProdutivaId(Long.parseLong(spnUnidadeProdutiva.getSelectedItem().toString().split("-")[0]));
        boletim.setSafraId(Long.parseLong(spnSafra.getSelectedItem().toString().split("-")[0]));
        boletim.setObservacao(edtObservacao.getText().toString());

        Gson g = new Gson();

        BoletimService boletimService = new BoletimService();

        String retorno = boletimService.setBoletim(g.toJson(boletim));

        if(retorno.equals("200")){
            Toast.makeText(this, "Boletim salvo com sucesso", Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        } else {
            Toast.makeText(this, "Erro ao salvar boletim", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

}
