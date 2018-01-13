package com.example.myapplication;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by leelo on 1/10/2018.
 */

class DownloadTask extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... urls) {

        String result = "";
        URL url;
        HttpURLConnection urlConnection = null;



        try {
            url = new URL(urls[0]);

            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader reader = new InputStreamReader(in);

            int data = reader.read();

            while (data != -1) {

                char current = (char) data;

                result += current;

                data = reader.read();


            }

             return result;
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        try {

            JSONObject jsonObject = new JSONObject(result);

            JSONObject weatherData = new JSONObject(jsonObject.getString("main"));

            Double tempature = Double.parseDouble(weatherData.getString("temp"));

            int tempatureInteger = (int) (tempature * 1.8-459.67);

            String placeName = jsonObject.getString("name");

            ItemListActivity.tempatureTextView.setText(String.valueOf(tempatureInteger));

            ItemListActivity.placeTextView.setText(placeName);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}

