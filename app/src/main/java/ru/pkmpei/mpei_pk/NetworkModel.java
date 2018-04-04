package ru.pkmpei.mpei_pk;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by infrostorm on 15.12.2017.
 */

public class NetworkModel extends AsyncTask<String, String, String> {
    private static final String charset = "UTF-8";
    private ProtocolMPEI protocolMPEI;
    NetworkModel(ProtocolMPEI protocolMPEI)
    {
        this.protocolMPEI = protocolMPEI;
    }

    public void sendRequest(String address, String data) {
        this.execute(address, data);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(String... params) {
        String urlString = params[0]; // URL to call
        String data = params[1]; //data to post
        StringBuilder return_data= new StringBuilder();
        OutputStream out;
        InputStream in;
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            out = new BufferedOutputStream(urlConnection.getOutputStream());
            in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(out, charset));
            BufferedReader reader = new BufferedReader( new InputStreamReader(in,charset ));
            writer.write(data);
            //writer.flush();
            String line;
            do {
                line = reader.readLine();
                if (line!=null) return_data.append(line);
            }while (line!=null);
            reader.readLine();
            writer.close();
            out.close();
            urlConnection.connect();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
            return return_data.toString();
        }

        return return_data.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        protocolMPEI.MessageReceiver(s);
    }
}
