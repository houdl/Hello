package com.example.administrator.hello.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.hello.R;
import com.example.administrator.hello.adapters.UsersAdapter;
import com.example.administrator.hello.models.User;

import java.util.ArrayList;

public class TestListView1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list_view1);

        init();
    }

    private void init() {
        // add a adapter to listView
        // Construct the data source
        final ArrayList<User> arrayOfUsers = new ArrayList<User>();
        arrayOfUsers.add(new User("aa", "bb"));
        arrayOfUsers.add(new User("ss", "cc"));
        // Create the adapter to convert the array to views
        UsersAdapter adapter = new UsersAdapter(this, arrayOfUsers);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvUsers);
        listView.setAdapter(adapter);

        // init click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tvUserName = (TextView) view.findViewById(R.id.tvName);
                User user = arrayOfUsers.get(position);
                Toast.makeText(getApplicationContext(), user.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
