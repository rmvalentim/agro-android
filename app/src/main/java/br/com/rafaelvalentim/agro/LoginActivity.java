package br.com.rafaelvalentim.agro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.rafaelvalentim.agro.Model.Cultura;
import br.com.rafaelvalentim.agro.Service.CulturaService;
import br.com.rafaelvalentim.agro.WebService.HttpGETService;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Spinner listUsers = (Spinner) findViewById(R.id.lista);

        CulturaService culturaService = new CulturaService();

        SpinnerAdapter adapter = culturaService.getCulturaAdapter(getApplicationContext());

        // Seta o adapter criado na ListView (Exibe o resultado)
        listUsers.setAdapter(adapter);
    }


}
