package com.example.administrator.hello.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.query.Delete;
import com.example.administrator.hello.R;
import com.example.administrator.hello.adapters.ItemsAdapter;
import com.example.administrator.hello.models.Category;
import com.example.administrator.hello.models.Item;

import java.util.List;
import java.util.Random;

public class ActiveAndroidActivity extends AppCompatActivity {

    List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_android);

        init();
    }

    private void init() {
        updateListView();
        initClick();
    }

    private void updateListView() {
        items = Item.getAll();
        // Create the adapter to convert the array to views
        ItemsAdapter adapter = new ItemsAdapter(this, items);
        // Attach the adapter to a ListView
            ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
    }

    private  void  initClick() {
        Button button_show = (Button)findViewById(R.id.button_show);

        button_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Category restaurants = new Category();
                restaurants.remoteId = getRandomLong();
                restaurants.name = "Restaurants";
                restaurants.save();

                Item item1 = new Item();
                item1.remoteId = getRandomLong();

                item1.category = restaurants;
                item1.name = "Outback Steakhouse";
                item1.save();

                updateListView();
            }
        });

        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                new Delete().from(Item.class).where("id = ?", items.get(position).getId()).execute();
                updateListView();
                Toast.makeText(getApplicationContext(), "success update list view!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private long getRandomLong() {
        long LOWER_RANGE = 0; //assign lower range value
        long UPPER_RANGE = 1000000; //assign upper range value
        Random random = new Random();


        long randomValue = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        return  randomValue;
    }
}
