package com.learning.popupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_1);
    }
    public void shaoClick(View view){
        View popupView = getLayoutInflater().inflate(R.layout.activity_popupview,null);
        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,true);

        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher));
        popupWindow.showAsDropDown(view,200,100);
    }
}