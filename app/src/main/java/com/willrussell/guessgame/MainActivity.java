package com.willrussell.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
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

        inputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    onClick(v);
                    return true;
                }
                return false;
            }
        });
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
            Intent intent = new Intent(this, PartyActivity.class);
            startActivityForResult(intent, 1);
        } else {
            numberView.setText(getResources().getString(R.string.guess_incorrect_label));
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            generateNumber();
        }
    }
}
