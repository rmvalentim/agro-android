package br.com.rafaelvalentim.agro;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.rafaelvalentim.agro.Model.Cultura;
import br.com.rafaelvalentim.agro.Model.OperacaoAgricola;
import br.com.rafaelvalentim.agro.Model.Produto;
import br.com.rafaelvalentim.agro.Service.BoletimService;
import br.com.rafaelvalentim.agro.Service.CulturaService;
import br.com.rafaelvalentim.agro.Service.EquipamentoService;
import br.com.rafaelvalentim.agro.Service.OperacaoAgricolaService;
import br.com.rafaelvalentim.agro.Service.OperadorService;
import br.com.rafaelvalentim.agro.Service.ProdutoService;
import br.com.rafaelvalentim.agro.Service.TalhaoService;
import br.com.rafaelvalentim.agro.WebService.HttpGETService;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }


    public void realizaLogin(View view) {

        if (isOnline()) {
            Intent i = new Intent(this, ApontamentoActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Sem conexão com a internet",Toast.LENGTH_SHORT).show();
        }

    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
