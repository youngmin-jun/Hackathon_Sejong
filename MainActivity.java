package com.test.searchingyourfuture;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> Search_Data = new ArrayList<String>();

        for(int i=0; i<12 ;i++){
            Search_Data.add("Test"+i);
        }
        ArrayAdapter<String> Search_DataADT;
        Search_DataADT = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,Search_Data);

        ListView list = (ListView)findViewById(R.id.Search_list);
        list.setAdapter(Search_DataADT);
        list.setOnItemClickListener(mItemClickerListner);

    }

    AdapterView.OnItemClickListener mItemClickerListner = new AdapterView.OnItemClickListener(){
        public void onItemClick(AdapterView parent, View view, int position, long id){
            Resources res = getResources();
            String strText = (String) parent.getItemAtPosition(position);

            Toast.makeText(getApplicationContext(),strText,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this,
                    DetailActivity.class);
            intent.putExtra("KeyWord",strText);
            startActivity(intent);


        }
    };

}
