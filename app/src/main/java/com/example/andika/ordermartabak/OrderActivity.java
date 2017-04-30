package com.example.andika.ordermartabak;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    EditText mTextNama;
    TextView mTextHarga, mTextQty;
    Button mButtonOrder, mButtonPlus, mButtonMin;
    RadioGroup mRadioGroup;
    RadioButton mRadioItem1, mRadioItem2, mRadioItem3;
    String item = null;
    Context mContext;
    Spinner mSpinnerMenu;
    List<String> mListMenu = new ArrayList<>(); //membuat array list
    int harga = 0;
    int qty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mContext = getApplicationContext();
        mTextNama = (EditText) findViewById(R.id.TextNama);
        mTextHarga = (TextView) findViewById(R.id.mTextHarga);
        mButtonOrder = (Button) findViewById(R.id.mButtonOrder);
        mTextQty = (TextView) findViewById(R.id.mTextQty);
        mButtonPlus = (Button) findViewById(R.id.mButtonPlus);
        mButtonMin = (Button) findViewById(R.id.mButtonMin);
        // radio
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
        mRadioItem1 = (RadioButton) findViewById(R.id.mRadioItem1);
        mRadioItem2 = (RadioButton) findViewById(R.id.mRadioItem2);
        mRadioItem3 = (RadioButton) findViewById(R.id.mRadioItem3);
        // spinner
        mSpinnerMenu = (Spinner) findViewById(R.id.mSpinnerMenu);
        mListMenu.add("Ender's Game");
        mListMenu.add("To Kill A Mocking Bird");
        mListMenu.add("Divergent series");
        mListMenu.add("Percy Jackson series");
        mListMenu.add("The Mortal Instrument");
        mListMenu.add("The Maze Runner series");
        mListMenu.add("The Giver");
        mListMenu.add("The Perks of Being a Wallflower");
        mListMenu.add("Looking For Alaska");
        mListMenu.add("The Fault in Our Stars");
        mListMenu.add("Thirteen Reasons Why");
        mListMenu.add("Fifty Shades series");
        mListMenu.add("Sherlock Holmes Series");
        mListMenu.add("Gone Girl");
        mListMenu.add("The Hound of The Baskervilles");//memasukan info ke spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mListMenu);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerMenu.setAdapter(dataAdapter);
    }

    public void onClickOrder(View view) { //hanya memilih salah satu radiobox dan mendapatkan text untuk item
        switch (mRadioGroup.getCheckedRadioButtonId()) {
            case R.id.mRadioItem1:
                item = mRadioItem1.getText().toString();
                break;
            case R.id.mRadioItem2:
                item = mRadioItem2.getText().toString();
                break;
            case R.id.mRadioItem3:
                item = mRadioItem3.getText().toString();
                break;
        }

        String to = "Andika.dicky@techie.com";
        String subject = mTextNama.getText().toString();
        String message = "Saya pesan "
                + mSpinnerMenu.getSelectedItem()
                + " sebanyak "
                + mTextQty.getText()
                + " buah, seharga "
                + mTextHarga.getText()
                + ", dengan tambahan "
                + item;

        Intent email = new Intent(Intent.ACTION_SEND); //order email
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Kirim email dengan"));
    }

    public void onClickPlus(View view) {
        harga = harga + 5; //logic tombol >
        qty = qty + 1;
        mTextQty.setText(qty + "");
        mTextHarga.setText("$" + harga);
    }

    public void onClickMin(View view) { //logic button <
        if (harga != 0) {
            harga = harga - 5;
            qty = qty - 1;
            mTextQty.setText(qty + "");
            mTextHarga.setText("$" + harga);
        } else {
            harga = 0;
            qty = 0;
            mTextQty.setText(qty + "");
            mTextHarga.setText("$" + harga);
        }
    }

    public void onClickReset(View v) {
        harga = 0; //logic reset button
        qty = 0;
        mTextNama.setText("");
        mTextHarga.setText("$" + harga);
        mTextQty.setText(qty + "");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
