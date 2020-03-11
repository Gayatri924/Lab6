package com.gopavajhalagayatri.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.res.Resources;

public class MainActivity extends AppCompatActivity {

    Button begin;
    Button replay;
    TextView number;
    ImageView character;
    CheckBox option1;
    CheckBox option2;
    CheckBox option3;
    CheckBox option4;
    int currentQ = 0;
    int score = 0;
    Resources res;
    String[][] names;
    CheckBox[] boxes;
    int[] allCharacters;
    TextView scoring;
    Listener x = new Listener();
    Listener2 y = new Listener2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();
        names = new String[][]{res.getStringArray(R.array.one), res.getStringArray(R.array.two),
                res.getStringArray(R.array.three), res.getStringArray(R.array.four),
                res.getStringArray(R.array.five), res.getStringArray(R.array.six),
                res.getStringArray(R.array.seven), res.getStringArray(R.array.eight),
                res.getStringArray(R.array.nine), res.getStringArray(R.array.ten)};
        allCharacters = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,
                R.drawable.image5, R.drawable.image6,R.drawable.image7, R.drawable.image8, R.drawable.image9,
                R.drawable.image10};
        begin = findViewById(R.id.begin);
        begin.setOnClickListener(y);

    }

    public class Listener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            CheckBox checkBox = (CheckBox)v;
            if(checkBox.isChecked()){
                checkBox.setChecked(false);
                String[] correct = res.getStringArray(R.array.correct);
                if(checkBox.getText().equals(correct[currentQ])) score += 1;
                currentQ += 1;
                if(currentQ > 9) { //HERE
                    setContentView(R.layout.end_quiz);
                    scoring = findViewById(R.id.scoring);
                    scoring.setText("Game Over! You got " + score + " points.");
                    replay = findViewById(R.id.replay);
                    replay.setOnClickListener(y);
                }else{
                    String[] options = names[currentQ];
                    number.setText("Question "+ (currentQ + 1));
                    character.setImageResource(allCharacters[currentQ]);
                    for(int i = 0; i < 4; i++){
                        boxes[i].setText(options[i]);
                    }
                }
            }
        }
    }

    public class Listener2 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            setContentView(R.layout.question1);
            currentQ = 0;
            score = 0;
            number = findViewById(R.id.questionNum);
            character = findViewById(R.id.image);
            option1 = findViewById(R.id.one);
            option2 = findViewById(R.id.two);
            option3 = findViewById(R.id.three);
            option4 = findViewById(R.id.four);
            option1.setOnClickListener(x);
            option2.setOnClickListener(x);
            option3.setOnClickListener(x);
            option4.setOnClickListener(x);
            boxes = new CheckBox[]{option1, option2, option3, option4};
        }
    }
}

//Fix the restart button --> Make the high score page