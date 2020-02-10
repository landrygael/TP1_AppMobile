package com.example.tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AnimalList Animallist = new AnimalList();
        final ListView listview = (ListView) findViewById(R.id.list);
        String[] values = Animallist.getNameArray();

        // Create an ArrayAdapter, that will actually make the Strings above appear in the ListView
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // Do something in response to the click
                final String item = (String) parent.getItemAtPosition(position);
                Intent MyIntent = new Intent ( MainActivity.this, AnimalActivity.class);

                //String name = listview.getItemAtPosition(position).toString();
                Animal Animal = AnimalList.getAnimal(item);

               MyIntent.putExtra("name",item);


                startActivity(MyIntent);
            }
        });
    }




}
