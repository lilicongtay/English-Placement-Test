package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity class for EPT Calculator App.
 *
 * This activity allows the user to:
 * 1. Enter student name
 * 2. Enter Writing marks
 * 3. Enter Speaking marks
 * 4. Enter Listening marks
 *
 * The application calculates:
 * - Final marks
 * - Final grade
 *
 * Then sends the result to ResultActivity.
 */
public class MainActivity extends AppCompatActivity {

    // Declare EditText components
    EditText editName;
    EditText editWriting;
    EditText editSpeaking;
    EditText editListening;

    // Declare button component
    Button btnCalculate;

    /**
     * onCreate() method runs when activity starts.
     *
     * @param savedInstanceState Previous activity state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Connect Java file to XML layout
        setContentView(R.layout.activity_main);

        // Link Java variables with XML components
        editName = findViewById(R.id.editName);
        editWriting = findViewById(R.id.editWriting);
        editSpeaking = findViewById(R.id.editSpeaking);
        editListening = findViewById(R.id.editListening);
        btnCalculate = findViewById(R.id.btnCalculate);

        /**
         * Button click event.
         * Executes when user presses Calculate button.
         */
        btnCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Get student name from EditText
                String name = editName.getText().toString();

                // Convert input marks from String to double
                double writing = Double.parseDouble(
                        editWriting.getText().toString());

                double speaking = Double.parseDouble(
                        editSpeaking.getText().toString());

                double listening = Double.parseDouble(
                        editListening.getText().toString());

                /**
                 * Calculate final marks using percentage:
                 * Writing = 50%
                 * Speaking = 30%
                 * Listening = 20%
                 */
                double finalMarks =
                        (writing * 0.5) +
                                (speaking * 0.3) +
                                (listening * 0.2);

                // Variable to store final grade
                String grade;

                /**
                 * Determine grade based on final marks.
                 */
                if(finalMarks >= 80)
                    grade = "A";

                else if(finalMarks >= 60)
                    grade = "B";

                else if(finalMarks >= 40)
                    grade = "C";

                else
                    grade = "Fail";

                /**
                 * Intent is used to move
                 * from MainActivity to ResultActivity.
                 */
                Intent intent = new Intent(
                        MainActivity.this,
                        ResultActivity.class);

                // Send data to ResultActivity
                intent.putExtra("name", name);
                intent.putExtra("marks", finalMarks);
                intent.putExtra("grade", grade);

                // Start ResultActivity
                startActivity(intent);
            }
        });
    }
}