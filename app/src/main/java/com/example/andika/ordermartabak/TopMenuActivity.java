package com.example.andika.ordermartabak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class TopMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void onClickBuku(View v){
        Intent i = new Intent(this,young_adult.class);
        startActivity(i); // Pindah Intent
    }
    public void onClickBuku2(View v){
        Intent i = new Intent(this,Fantasy.class);
        startActivity(i); // Pindah Intent
    }
    public void onClickBuku3(View v){
        Intent i = new Intent(this,Fiction.class);
        startActivity(i); // Pindah Intent
    }
    public void onClickBuku4(View v){
        Intent i = new Intent(this,Romance.class);
        startActivity(i); // Pindah Intent
    }
    public void onClickBuku5(View v){
        Intent i = new Intent(this,Mystery.class);
        startActivity(i); // Pindah Intent
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){ //Bila menekan tombol back maka akan kembali ke MainActivity.xml
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
