package br.com.rafaelvalentim.agro.WebService;

import android.os.AsyncTask;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPOSTService extends AsyncTask<String, String, String> {

    private final URL url;

    public HttpPOSTService(URL url){
        this.url = url;
    }

    @Override
    protected String doInBackground(String... strings) {
        String data = strings[0];
        System.out.println(this.url);
        OutputStream out = null;
        int status = 0;

        URL url = this.url;
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);

            out = new BufferedOutputStream(connection.getOutputStream());

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.write(data);
            writer.flush();
            writer.close();
            out.close();

            connection.connect();

            status = connection.getResponseCode();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.valueOf(status);

        }

        @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

}
