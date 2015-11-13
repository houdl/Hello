package com.example.administrator.hello.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.hello.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        Button login_btn_show1 = (Button)findViewById(R.id.btn_show1);
        login_btn_show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hello, you have click me, this a good start!", Toast.LENGTH_SHORT).show();
            }
        });

        Button login_btn_show2 = (Button)findViewById(R.id.btn_show2);
        login_btn_show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scrolling = new Intent(MainActivity.this, ScrollingActivity.class);
                startActivity(scrolling);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button login_btn_show3 = (Button)findViewById(R.id.btn_show3);
        login_btn_show3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scrolling = new Intent(MainActivity.this, TabbedActivity.class);
                startActivity(scrolling);
            }
        });

        Button login_btn_show4 = (Button)findViewById(R.id.btn_show4);
        login_btn_show4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scrolling = new Intent(MainActivity.this, TestListView1Activity.class);
                startActivity(scrolling);
            }
        });

        Button login_btn_show5 = (Button)findViewById(R.id.btn_show5);
        login_btn_show5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scrolling = new Intent(MainActivity.this, TestFragmentActivity.class);
                startActivity(scrolling);
            }
        });

        Button login_btn_show6 = (Button)findViewById(R.id.btn_show6);
        login_btn_show6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scrolling = new Intent(MainActivity.this, TestClickActivity.class);
                startActivity(scrolling);
            }
        });

        Button login_btn_show7 = (Button)findViewById(R.id.btn_show7);
        login_btn_show7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scrolling = new Intent(MainActivity.this, ActiveAndroidActivity.class);
                startActivity(scrolling);
            }
        });

    }
}
