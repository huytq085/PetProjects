package com.example.huy.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
//    0 = red , 1 = yellow
    private int activePlayer = 0;
    private int stepCount = 0;
    private boolean gameIsActive = true;
    private int gameStates[] = {2,2,2,2,2,2,2,2,2};
    private int winningPositions[][] = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        if (counter.getDrawable() == null && gameIsActive){
            stepCount++;
            System.out.println("step " + stepCount);
            counter.setTranslationY(-1000f);
            if (activePlayer == 0){
                counter.setImageResource(R.drawable.red);
            } else {
                counter.setImageResource(R.drawable.yellow);
            }
            gameStates[Integer.parseInt((String)counter.getTag())] = activePlayer;
            counter.animate().translationYBy(1000f).setDuration(100);
//            Check win
            for (int[] winState : winningPositions){
                if (gameStates[winState[0]] == gameStates[winState[1]] &&
                        gameStates[winState[0]]== gameStates[winState[2]] &&
                            gameStates[winState[0]] == activePlayer) {
                    gameIsActive = false;
                    TextView txtWinner = findViewById(R.id.txtWinner);
                    RelativeLayout layoutPlayAgain = findViewById(R.id.layoutPlayAgain);
                    layoutPlayAgain.setVisibility(View.VISIBLE);
                    if (activePlayer == 0) {
                        txtWinner.setText("Red has won.");
                        layoutPlayAgain.setBackgroundColor(Color.RED);
                    } else {
                        txtWinner.setText("Yellow has won.");
                        layoutPlayAgain.setBackgroundColor(Color.YELLOW);
                    }
                } else if (stepCount == 9){
                    gameIsActive = false;
                    TextView txtWinner = findViewById(R.id.txtWinner);
                    txtWinner.setText("It's a draw.");
                    RelativeLayout layoutPlayAgain = findViewById(R.id.layoutPlayAgain);
                    layoutPlayAgain.setVisibility(View.VISIBLE);
                }
            }
            activePlayer = (activePlayer == 0) ? 1 : 0;
        }

    }

    public void playAgain(View view){
        System.out.println("pay again");
        gameIsActive = true;
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        for(int i = 0; i < gridLayout.getChildCount(); i++){
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
        RelativeLayout layoutPlayAgain = findViewById(R.id.layoutPlayAgain);
        layoutPlayAgain.setVisibility(View.INVISIBLE);
        activePlayer = 0;
        for (int i = 0; i < gameStates.length; i++){
            gameStates[i] = 2;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
