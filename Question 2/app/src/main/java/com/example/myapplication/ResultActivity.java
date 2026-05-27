package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * ResultActivity class.
 *
 * This activity receives:
 * - Student name
 * - Final marks
 * - Grade
 *
 * Then displays the result on screen.
 */
public class ResultActivity extends AppCompatActivity {

    // Declare TextView component
    TextView textResult;

    /**
     * onCreate() method executes when activity starts.
     *
     * @param savedInstanceState Previous activity state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Connect Java file with XML layout
        setContentView(R.layout.activity_result);

        // Link TextView variable with XML TextView
        textResult = findViewById(R.id.textResult);

        /**
         * Receive data from MainActivity using Intent.
         */
        String name = getIntent().getStringExtra("name");

        double marks = getIntent().getDoubleExtra(
                "marks",
                0);

        String grade = getIntent().getStringExtra("grade");

        /**
         * Create output text.
         */
        String output =
                "Student Name: " + name +
                        "\nFinal Marks: " + marks +
                        "\nGrade: " + grade;

        // Display result on screen
        textResult.setText(output);
    }
}
