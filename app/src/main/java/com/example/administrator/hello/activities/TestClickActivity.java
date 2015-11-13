package com.example.administrator.hello.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.hello.R;

public class TestClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_click);
        init();
    }

    private void init() {
        Button login_btn_show = (Button)findViewById(R.id.button_test_click);
        login_btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hello, you have click me!", Toast.LENGTH_SHORT).show();
            }
        });

        login_btn_show.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Hello, you have on long click me!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

}
