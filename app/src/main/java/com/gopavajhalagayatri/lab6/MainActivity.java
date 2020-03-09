package com.gopavajhalagayatri.lab6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button begin;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begin = findViewById(R.id.begin);
        nextButton = findViewById(R.id.next);
        Listener x = new Listener();
        begin.setOnClickListener(x);
        nextButton.setOnClickListener(x);
    }

    public class Listener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
