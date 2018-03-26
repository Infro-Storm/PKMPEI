package ru.pkmpei.mpei_pk;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import ru.pkmpei.mpei_pk.dataTypes.SessionData;

/**
 * Created by infrostorm on 15.12.2017.
 */

public class NetworkModel extends AsyncTask<String, String, String> {

    private String pk_host="91.211.106.34";
    private String reg_url="/www/ajax/pk_reg_user.php";
    private String log_url="/www/ajax/pk_auth.php";
    Context context;

    public NetworkModel (Context context)
    {
        this.context = context;
    }
//    private String _url="/www/ajax/pk_reg_user.php";

    public SessionData GetSessionData(String login, String password) {
        String siteID = null;
            this.execute("http://" + pk_host + log_url, "login=" + login + "&password=" + password);
        return new SessionData(login, password, siteID);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(String... params) {

        String urlString = params[0]; // URL to call

        String data = params[1]; //data to post

        OutputStream out = null;
        try {

            URL url = new URL(urlString);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            out = new BufferedOutputStream(urlConnection.getOutputStream());

            BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(out, "UTF-8"));

            writer.write(data);

            writer.flush();

            writer.close();

            out.close();

            urlConnection.connect();


        } catch (Exception e) {

            System.out.println(e.getMessage());



        }

        return urlString;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, "Результат: " + s, Toast.LENGTH_LONG).show();
    }
}
