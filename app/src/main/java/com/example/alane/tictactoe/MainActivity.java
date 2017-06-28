package com.example.alane.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public ImageButton f1, f2, f3, f4, f5, f6, f7, f8, f9;
    private Integer turnPlayer = 1;
    private TextView turn;
    private Integer[] flag = new Integer[9];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for (int i = 0; i < flag.length; i++)
            flag[i] = null;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f1 = (ImageButton) findViewById(R.id.F1);
        f2 = (ImageButton) findViewById(R.id.F2);
        f3 = (ImageButton) findViewById(R.id.F3);
        f4 = (ImageButton) findViewById(R.id.F4);
        f5 = (ImageButton) findViewById(R.id.F5);
        f6 = (ImageButton) findViewById(R.id.F6);
        f7 = (ImageButton) findViewById(R.id.F7);
        f8 = (ImageButton) findViewById(R.id.F8);
        f9 = (ImageButton) findViewById(R.id.F9);
        turn = (TextView) findViewById(R.id.turn);
        f1.setOnClickListener(this);
        f2.setOnClickListener(this);
        f3.setOnClickListener(this);
        f4.setOnClickListener(this);
        f5.setOnClickListener(this);
        f6.setOnClickListener(this);
        f7.setOnClickListener(this);
        f8.setOnClickListener(this);
        f9.setOnClickListener(this);
        turn.setText("Jugador A");

    }

    public void nextTurn() {
        win();
        if (turnPlayer == 1) {
            turn.setText("Jugador B");
            turnPlayer = 2;
        } else {
            turn.setText("Jugador A");
            turnPlayer = 1;
        }
    }


    private void changePiece(Integer piece) {
        switch (piece) {
            case R.id.F1:
                f1.setImageResource(changeColorPiece());
                flag[0] = turnPlayer;
                nextTurn();
                f1.setEnabled(false);

                break;
            case R.id.F2:
                f2.setImageResource(changeColorPiece());
                flag[1] = turnPlayer;
                nextTurn();
                f2.setEnabled(false);
                break;
            case R.id.F3:
                f3.setImageResource(changeColorPiece());
                flag[2] = turnPlayer;
                nextTurn();
                f3.setEnabled(false);
                break;
            case R.id.F4:
                f4.setImageResource(changeColorPiece());
                flag[3] = turnPlayer;
                nextTurn();
                f4.setEnabled(false);
                break;
            case R.id.F5:
                f5.setImageResource(changeColorPiece());
                flag[4] = turnPlayer;
                nextTurn();
                f5.setEnabled(false);
                break;
            case R.id.F6:
                f6.setImageResource(changeColorPiece());
                flag[5] = turnPlayer;
                nextTurn();
                f6.setEnabled(false);
                break;
            case R.id.F7:
                f7.setImageResource(changeColorPiece());
                flag[6] = turnPlayer;
                nextTurn();
                f7.setEnabled(false);
                break;
            case R.id.F8:
                f8.setImageResource(changeColorPiece());
                flag[7] = turnPlayer;
                nextTurn();
                f8.setEnabled(false);
                break;
            case R.id.F9:
                f9.setImageResource(changeColorPiece());
                flag[8] = turnPlayer;
                nextTurn();
                f9.setEnabled(false);
                break;
        }
    }

    public int changeColorPiece() {
        if (turnPlayer == 1)
            return R.drawable.player;
        return R.drawable.android;

    }


    public void win() {

        try {
            if ((flag[0] == flag[1] && flag[1] == flag[2] && flag[2] == turnPlayer) ||
                    (flag[3] == flag[4] && flag[4] == flag[5] && flag[5] == turnPlayer) ||
                    (flag[6] == flag[7] && flag[7] == flag[8] && flag[8] == turnPlayer) ||
                    (flag[0] == flag[3] && flag[3] == flag[6] && flag[6] == turnPlayer) ||
                    (flag[1] == flag[4] && flag[4] == flag[7] && flag[7] == turnPlayer) ||
                    (flag[2] == flag[5] && flag[5] == flag[8] && flag[8] == turnPlayer) ||
                    (flag[0] == flag[4] && flag[4] == flag[8] && flag[8] == turnPlayer) ||
                    (flag[2] == flag[4] && flag[4] == flag[6] && flag[6] == turnPlayer)) {
                Intent i = new Intent(MainActivity.this, WinnerActivity.class);
                i.putExtra("Winner", turnPlayer);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        } catch (Exception e) {

        }

    }

    @Override
    public void onClick(View view) {
        changePiece(view.getId());
    }

}
