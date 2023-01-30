package com.learning.processingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar processBar;
    private ProgressBar processBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        processBar = findViewById(R.id.pb);
        processBar2 = findViewById(R.id.pb2);
    }
    public void leoClick(View view){
        if(processBar.getVisibility() == View.GONE){
            processBar.setVisibility(View.VISIBLE);
        }else{
            processBar.setVisibility(View.GONE);
        }
    }
    public void load(View view){
        int progress = processBar2.getProgress();

        if(progress != 100){
            progress +=10;
            processBar2.setProgress(progress);
        }else{
            progress = 0;
            processBar2.setProgress(progress);
        }
    }

}