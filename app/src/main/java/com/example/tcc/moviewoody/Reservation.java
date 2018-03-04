package com.example.tcc.moviewoody;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import java.util.ArrayList;
import java.util.List;

public class Reservation extends AppCompatActivity implements View.OnClickListener {
    Button buttonCancel;

    List<String> spinnerArray =  new ArrayList<String>();
ArrayAdapter<CharSequence> adapter;

//spinnerArray.add("item1");
//spinnerArray.add("item2");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
       Spinner CitySpinner = (Spinner) findViewById(R.id.spinnerCity);

        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(this);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CitySpinner.setAdapter(adapter);
        CitySpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
    @Override
    public void onClick(View view) {
        if (view == buttonCancel) {
            finish();
            startActivity(new Intent(this, profileActivity.class));
        }


    }



}