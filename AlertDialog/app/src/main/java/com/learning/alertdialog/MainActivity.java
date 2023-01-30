package com.learning.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int bet = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_1);
    }
    public void leoClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher)
                .setTitle("电量剩余" + bet + "%，是否开启超级省电模式？")
                .setMessage("系统大部分功能将被限制，如限制性能和后台运行，关闭系统动效等，同时最多准许使用六个应用。")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (bet >= 2) {
                            bet = bet-1;
                            builder.setTitle("电量剩余" + bet + "%，是否开启超级省电模式？").create().show();
                        } else {
                            builder2.create().show();
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.create().show();
                    }
                })
                .create()
                .show();

        builder2.setIcon(R.mipmap.ic_launcher)
                .setTitle("电量已耗尽")
                .setMessage("手机将30秒内关闭，请尽快连接电源！！！")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        bet = 100;
                        builder.setTitle("电量剩余" + bet + "%，是否开启超级省电模式？").create().show();
                    }
                })
                .create();

    }

}