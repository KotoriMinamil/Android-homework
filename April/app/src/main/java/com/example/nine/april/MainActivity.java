package com.example.nine.april;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;                            //声明变量
    private MyReceiver myReceiver;
    int button_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter(); //首先创建一个IntentFilter的实例
        intentFilter.addAction("com.example.broadcasttest1.MY_BROADCAST");//添加一条Action
        myReceiver = new MyReceiver();//首先创建一个NetworkChangeReceiver的实例

        Button button = (Button)findViewById(R.id.button);          //获取按钮对象
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){                          //按钮监听
                Intent intent = new Intent("com.example.broadcasttest1.MY_BROADCAST");
                sendBroadcast(intent);
                button_count = 1;
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);          //获取按钮对象
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){                          //按钮监听
                Intent intent = new Intent("com.example.broadcasttest1.MY_BROADCAST");
                sendBroadcast(intent);
                button_count = 2;
            }
        });

        Button button3 = (Button)findViewById(R.id.button3);          //获取按钮对象
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){                          //按钮监听
                Intent intent = new Intent("com.example.broadcasttest1.MY_BROADCAST");
                sendBroadcast(intent);
                button_count = 3;
            }
        });

        registerReceiver(myReceiver,intentFilter);//注册，传入2个实例
    }

    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(myReceiver);//取消注册
    }

    //继承和重写onReceive()方法
    class  MyReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent){

            if(button_count==1) {
                Toast.makeText(context, "李明睿  获得  钢琴", Toast.LENGTH_SHORT).show();
            }
            else if(button_count==2) {
                Toast.makeText(context, "李明睿  获得  小提琴", Toast.LENGTH_SHORT).show();
            }
            else if (button_count==3){
                Toast.makeText(context, "李明睿  获得  爱公生的心", Toast.LENGTH_SHORT).show();
            }


        }
    }

}
