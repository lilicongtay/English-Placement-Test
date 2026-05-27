package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity class for Zoo Taiping application.
 *
 * This application displays:
 * 1. A zoo image
 * 2. Welcome text
 * 3. List of animals using ListView
 *
 * When the user clicks an animal name,
 * a Toast message will display the selected animal.
 */
public class MainActivity extends AppCompatActivity {

    // Declare ListView object
    ListView listView;

    /**
     * Array that stores animal names.
     */
    String[] animals = {
            "Tiger",
            "Elephant",
            "Giraffe",
    };

    /**
     * onCreate() method is called when
     * the activity starts.
     *
     * @param savedInstanceState Stores previous activity state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Connect Java file with XML layout
        setContentView(R.layout.activity_main);

        // Connect ListView variable with ListView from XML
        listView = findViewById(R.id.listAnimal);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                animals);

        // Set adapter to ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {


                Toast.makeText(
                        MainActivity.this,
                        animals[position],
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}