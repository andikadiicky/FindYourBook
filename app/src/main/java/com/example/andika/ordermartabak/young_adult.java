package com.example.andika.ordermartabak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class young_adult extends AppCompatActivity {
    private ListView lvItem;
    private String[] bukuDika = new String[]{
            "The Giver","The Perks of Being a Wallflower","Looking for Alaska"};
    //mendeklarasikan listview var dan menginisialasi array tipe data string
    //Step 1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_young_adult);

        getSupportActionBar().setTitle("Young Adult book lists"); //tampil title

        lvItem = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(young_adult.this, android.R.layout.simple_list_item_1, android.R.id.text1, bukuDika);
    /*
    Step 2
    Membinding atau memformat data
     */

        lvItem.setAdapter(adapter);
        //menset data di dalam listview

        //Step 3
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(young_adult.this, "Memilih : "+bukuDika[position], Toast.LENGTH_LONG).show();
                //memanggil set on Item ClickListener untuk Listview, jadi jika salah satu item list view diklik akan
                //akan bereaksi menampilkan toast atau aksi lainya.
                //Step 4
            }
        });
    }
}