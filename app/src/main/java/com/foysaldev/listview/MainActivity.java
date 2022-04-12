package com.foysaldev.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.ListViewid);
        searchView = findViewById(R.id.SearchViewid);

        String[] mymensinghDistrict = getResources().getStringArray(R.array.mymensingh_district);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.sample_layout,R.id.TextViewid,mymensinghDistrict);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = mymensinghDistrict[i];
                Intent intent = null;
                if (i == 0) {
                    Intent intent3 = new Intent(MainActivity.this, ActivityTwo.class);
                    startActivity(intent3);
                }
                else if (i == 1) {
                    Intent intent5 = new Intent(MainActivity.this, ActivityThird.class);
                    startActivity(intent5);
                }
                else if (i == 2) {

                }
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }
}