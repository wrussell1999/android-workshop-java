package com.willrussell.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int randomNumber;
    private TextView numberView;
    private EditText inputEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberView = findViewById(R.id.number_view);
        inputEditText = findViewById(R.id.user_input);
        generateNumber();
    }

    public void generateNumber() {
        Random random = new Random();
        this.randomNumber = random.nextInt(10);
    }

    public void onClick(View v) {
        String input = inputEditText.getText().toString();
        int guessedValue = Integer.parseInt(input);

        if (guessedValue == randomNumber) {
            numberView.setText(getResources().getString(R.string.guess_correct_label));
            generateNumber();
        } else {
            numberView.setText(getResources().getString(R.string.guess_incorrect_label));
        }
    }
}
