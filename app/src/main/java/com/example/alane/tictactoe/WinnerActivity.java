package com.example.alane.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by alane on 28/06/2017.
 */

public class WinnerActivity extends AppCompatActivity implements View.OnClickListener {
    TextView theWinner;
    Button exit;
    Button newGame;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner_layout);

        Bundle dates = getIntent().getExtras();
        Integer winner = dates.getInt("Winner");

        theWinner = (TextView) findViewById(R.id.theWinner);
        exit = (Button) findViewById(R.id.exit);
        newGame = (Button) findViewById(R.id.newGame);
        exit.setOnClickListener(this);
        newGame.setOnClickListener(this);

        if (winner == 1)
            theWinner.setText("Jugador A");
        else
            theWinner.setText("Jugador B");

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.exit) {
            finish();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else {
            Intent i = new Intent(WinnerActivity.this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
    }
}
