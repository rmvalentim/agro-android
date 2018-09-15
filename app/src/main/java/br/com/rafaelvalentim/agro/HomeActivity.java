package br.com.rafaelvalentim.agro;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }


    public void realizaApontamento(View view) {

        if (isOnline()) {
            Intent i = new Intent(this, ApontamentoActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Sem conexão com a internet",Toast.LENGTH_SHORT).show();
        }

    }

    public void realizaBoletim(View view) {

        if (isOnline()) {
            Intent i = new Intent(this, BoletimActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Sem conexão com a internet",Toast.LENGTH_SHORT).show();
        }

    }

    public void fechaAplicacao(View view) {
        this.finish();
        System.exit(0);
    }


    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
