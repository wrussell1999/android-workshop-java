package com.willrussell.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int randomNumber;
    private TextView numberView;
    private EditText userInputEditText;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberView = findViewById(R.id.number_view);
        userInputEditText = findViewById(R.id.user_input);
        submitButton = findViewById(R.id.submit_button);
        generateNumber();
    }

    public void generateNumber() {
        Random random = new Random();
        this.randomNumber = random.nextInt(10);
    }

    public void onClick(View v) {
        String input = userInputEditText.getText().toString();
        int guessedValue = Integer.parseInt(input);

        if (guessedValue == randomNumber) {
            numberView.setText(getResources().getString(R.string.guess_correct_label));
            generateNumber();
        } else {
            numberView.setText(getResources().getString(R.string.guess_incorrect_label));
        }
    }
}
