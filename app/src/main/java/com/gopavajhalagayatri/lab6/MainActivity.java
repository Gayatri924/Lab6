package com.gopavajhalagayatri.lab6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.res.Resources;

public class MainActivity extends AppCompatActivity {

    Button begin;
    Button nextQ;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();
        names = new String[][]{res.getStringArray(R.array.one), res.getStringArray(R.array.two)};
        begin = findViewById(R.id.begin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.question1);
                nextQ = findViewById(R.id.next);
                currentQ = 0;
                number = findViewById(R.id.questionNum);
                character = findViewById(R.id.image);
                option1 = findViewById(R.id.one);
                option2 = findViewById(R.id.two);
                option3 = findViewById(R.id.three);
                option4 = findViewById(R.id.four);
                Listener x = new Listener();
                option1.setOnClickListener(x);
                option2.setOnClickListener(x);
                option3.setOnClickListener(x);
                option4.setOnClickListener(x);
                boxes = new CheckBox[]{option1, option2, option3, option4};
                nextQ.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentQ += 1;
                        if(currentQ > 1) System.out.println(score);
                        else{
                            String[] options = names[currentQ];
                            for(int i = 0; i < 4; i++){
                                boxes[i].setText(options[i]);
                            }
                        }
                    }
                });
            }
        });
    }

    public class Listener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            CheckBox checkBox = (CheckBox)v;
            if(checkBox.isChecked()){
                String[] correct = res.getStringArray(R.array.correct);
                if(checkBox.getText() ==  correct[currentQ]) score += 1;
            }
        }
    }
}
