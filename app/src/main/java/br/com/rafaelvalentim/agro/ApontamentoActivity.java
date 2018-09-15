package br.com.rafaelvalentim.agro;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import br.com.rafaelvalentim.agro.Model.ApontamentoAPI;
import br.com.rafaelvalentim.agro.Service.ApontamentoService;
import br.com.rafaelvalentim.agro.Service.BoletimService;
import br.com.rafaelvalentim.agro.Service.CulturaService;
import br.com.rafaelvalentim.agro.Service.EquipamentoService;
import br.com.rafaelvalentim.agro.Service.OperacaoAgricolaService;
import br.com.rafaelvalentim.agro.Service.OperadorService;
import br.com.rafaelvalentim.agro.Service.ProdutoService;
import br.com.rafaelvalentim.agro.Service.TalhaoService;
import br.com.rafaelvalentim.agro.Service.UrlBaseService;

public class ApontamentoActivity extends AppCompatActivity {

    Spinner spnBoletim;
    Spinner spnCultura;
    Spinner spnTalhao;
    EditText edtQuantidadeHectares;
    Spinner spnOperacaoAgricola;
    Spinner spnEquipamentoPrincipal;
    Spinner spnEquipamentoApoio;
    EditText edtHorasMaquina;
    Spinner spnOperadorPrincipal;
    Spinner spnOperadorAjudante;
    EditText edtHorasHomem;
    Spinner spnProduto;
    EditText edtQuantidadeProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apontamento);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        spnBoletim = (Spinner) findViewById(R.id.boletim);
        spnCultura = (Spinner) findViewById(R.id.cultura);
        spnTalhao = (Spinner) findViewById(R.id.talhao);
        edtQuantidadeHectares = (EditText) findViewById(R.id.quantidadeHectares);
        spnOperacaoAgricola = (Spinner) findViewById(R.id.operacaoAgricola);
        spnEquipamentoPrincipal = (Spinner) findViewById(R.id.equipamentoPrincipal);
        spnEquipamentoApoio = (Spinner) findViewById(R.id.equipamentoApoio);
        edtHorasMaquina = (EditText) findViewById(R.id.horasMaquina);
        spnOperadorPrincipal = (Spinner) findViewById(R.id.operadorPrincipal);
        spnOperadorAjudante = (Spinner) findViewById(R.id.operadorAjudante);
        edtHorasHomem = (EditText) findViewById(R.id.horasHomem);
        spnProduto = (Spinner) findViewById(R.id.produto);
        edtQuantidadeProduto = (EditText) findViewById(R.id.quantidadeProduto);


        BoletimService boletimService = new BoletimService();
        CulturaService culturaService = new CulturaService();
        TalhaoService talhaoService = new TalhaoService();
        OperacaoAgricolaService operacaoAgricolaServiceService = new OperacaoAgricolaService();
        EquipamentoService equipamentoService = new EquipamentoService();
        OperadorService operadorService = new OperadorService();
        ProdutoService produtoService = new ProdutoService();

        if(isOnline()){
            // Seta o adapter criado na ListView (Exibe o resultado)
            spnBoletim.setAdapter(boletimService.getBoletimAdapter(getApplicationContext()));
            spnCultura.setAdapter(culturaService.getCulturaAdapter(getApplicationContext()));
            spnTalhao.setAdapter(talhaoService.getTalhaoAdapter(getApplicationContext()));
            spnOperacaoAgricola.setAdapter(operacaoAgricolaServiceService.getOperacaoAgricolaAdapter(getApplicationContext()));
            spnEquipamentoPrincipal.setAdapter(equipamentoService.getEquipamentoAdapter(getApplicationContext()));
            spnEquipamentoApoio.setAdapter(equipamentoService.getEquipamentoAdapter(getApplicationContext()));
            spnOperadorPrincipal.setAdapter(operadorService.getOperadorAdapter(getApplicationContext()));
            spnOperadorAjudante.setAdapter(operadorService.getOperadorAdapter(getApplicationContext()));
            spnProduto.setAdapter(produtoService.getProdutoAdapter(getApplicationContext()));
        } else {
            Toast.makeText(this, "Sem conexão com a internet",Toast.LENGTH_SHORT).show();
        }


    }

    public void salvarApontamento(View view) {
        ApontamentoAPI apontamento= new ApontamentoAPI();

        apontamento.setBoletimId(Long.parseLong(spnBoletim.getSelectedItem().toString().split("-")[0]));
        apontamento.setCulturaId(Long.parseLong(spnCultura.getSelectedItem().toString().split("-")[0]));
        apontamento.setTalhaoId(Long.parseLong(spnTalhao.getSelectedItem().toString().split("-")[0]));
        apontamento.setOperacaoAgricolaId(Long.parseLong(spnOperacaoAgricola.getSelectedItem().toString().split("-")[0]));
        apontamento.setEquipamentoPrincipalId(Long.parseLong(spnEquipamentoPrincipal.getSelectedItem().toString().split("-")[0]));
        apontamento.setEquipamentoApoioId(Long.parseLong(spnEquipamentoApoio.getSelectedItem().toString().split("-")[0]));
        apontamento.setOperadorPrincipalId(Long.parseLong(spnOperadorPrincipal.getSelectedItem().toString().split("-")[0]));
        apontamento.setOperadorAjudanteId(Long.parseLong(spnOperadorAjudante.getSelectedItem().toString().split("-")[0]));
        apontamento.setProdutoId(Long.parseLong(spnProduto.getSelectedItem().toString().split("-")[0]));

        if(!edtQuantidadeHectares.getText().toString().isEmpty()) apontamento.setHectaresTrabalhados(Double.parseDouble(edtQuantidadeHectares.getText().toString()));
        if(!edtHorasMaquina.getText().toString().isEmpty()) apontamento.setHorasEquipamentos(Double.parseDouble(edtHorasMaquina.getText().toString()));
        if(!edtHorasHomem.getText().toString().isEmpty()) apontamento.setHorasOperadores(Double.parseDouble(edtHorasHomem.getText().toString()));
        if(!edtQuantidadeProduto.getText().toString().isEmpty()) apontamento.setQuantidadeProduto(Double.parseDouble(edtQuantidadeProduto.getText().toString()));

        Gson g = new Gson();

        ApontamentoService apontamentoService = new ApontamentoService();

        String retorno = apontamentoService.setApontamento(g.toJson(apontamento));

        if(retorno.equals("200")){
            Toast.makeText(this, "Apontamento salvo com sucesso", Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        } else {
            Toast.makeText(this, "Erro ao salvar apontamento", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

}
