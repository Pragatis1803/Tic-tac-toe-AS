package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//0:cross.1:circle
    int crossIsShowing=1;
    boolean gameActive=true;
    int[] position={2,2,2,2,2,2,2,2,2};
    int[][] winnerCondition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void appear(View view){


            ImageView imageview = (ImageView) view;
        int taggedview = Integer.parseInt(imageview.getTag().toString());
        if(gameActive && position[taggedview]==2) {
            if (crossIsShowing == 1) {
                imageview.setTranslationY(-1500);
                imageview.setImageResource(R.drawable.thecross);
                crossIsShowing = 0;
            } else {
                imageview.setTranslationY(-1500);
                imageview.setImageResource(R.drawable.thecircle);
                crossIsShowing = 1;
            }
            imageview.animate().translationYBy(1500).setDuration(300);
            Log.i("Tag", imageview.getTag().toString());
            int c=0;
            position[taggedview] = crossIsShowing;
            for(int k=0;k<position.length;k++)
            {
                if(position[k]!=2)
                    c++;
            }
            for (int[] check : winnerCondition) {
                if (position[check[0]] == position[check[1]] && position[check[1]] == position[check[2]] && position[check[0]] != 2) {
                    gameActive = false;
                    TextView textView=(TextView) findViewById(R.id.textView);
                    Button playagainButton= (Button) findViewById(R.id.playagainButton);
                    textView.setVisibility(View.VISIBLE);
                    String winner;
                    if(position[check[0]]==0)
                        winner="CROSS";
                    else
                        winner="CIRCLE";
                    textView.setText(winner+" HAS WON");
                    playagainButton.setVisibility(View.VISIBLE);
                }
                else if(c==9)
                {
                    TextView textView=(TextView) findViewById(R.id.textView);
                    Button playagainButton= (Button) findViewById(R.id.playagainButton);
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("NO ONE HAS WON");
                    playagainButton.setVisibility(View.VISIBLE);

                }
            }


        }

    }
    public void playAgain(View view){
        TextView textView=(TextView) findViewById(R.id.textView);
        Button playagainButton= (Button) findViewById(R.id.playagainButton);
        textView.setVisibility(View.INVISIBLE);
        playagainButton.setVisibility(View.INVISIBLE);
        /*GridLayout gridLayout=(GridLayout) findViewById(R.id.gridLayout);
        for(int i=0; i<gridLayout.getChildCount();i++)
        {
            ImageView fresh= (ImageView) gridLayout.getChildAt(i);
            fresh.setImageDrawable(null);
        }*/
        ImageView imageView1= (ImageView) findViewById(R.id.imageView1);
        ImageView imageView2= (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3= (ImageView) findViewById(R.id.imageView3);
        ImageView imageView4= (ImageView) findViewById(R.id.imageView4);
        ImageView imageView5= (ImageView) findViewById(R.id.imageView5);
        ImageView imageView6= (ImageView) findViewById(R.id.imageView6);
        ImageView imageView7= (ImageView) findViewById(R.id.imageView7);
        ImageView imageView8= (ImageView) findViewById(R.id.imageView8);
        ImageView imageView9= (ImageView) findViewById(R.id.imageView9);
        imageView1.setImageDrawable(null);
        imageView2.setImageDrawable(null);
        imageView3.setImageDrawable(null);
        imageView4.setImageDrawable(null);
        imageView5.setImageDrawable(null);
        imageView6.setImageDrawable(null);
        imageView7.setImageDrawable(null);
        imageView8.setImageDrawable(null);
        imageView9.setImageDrawable(null);
         crossIsShowing=1;
         gameActive=true;
        for(int j=0; j<position.length; j++)
        {
            position[j]=2;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
