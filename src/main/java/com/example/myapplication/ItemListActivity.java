package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import static com.example.myapplication.R.array.*;
import static com.example.myapplication.R.array.cities_array;

/**import com.example.myapplication.dummy.DummyContent;

import java.util.List;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {


    static TextView placeTextView;
    static TextView tempatureTextView;

    protected ItemListActivity(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
      Whether or not the activity is in two-pane mode, i.e. running on a tablet
      device.
     */


        tempatureTextView = (TextView) findViewById(R.id.);



        String [] city;

        city = getResources().getStringArray(Integer.parseInt(String.valueOf(cities_array)));


        DownloadTask task = new DownloadTask();

        task.execute("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=93e83302a47915b405f974fa52626d5e");



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());



              }



}
