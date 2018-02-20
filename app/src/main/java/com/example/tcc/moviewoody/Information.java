package com.example.tcc.moviewoody;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

public class Information extends AppCompatActivity {



    private DatabaseReference databaseReference;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }
}
