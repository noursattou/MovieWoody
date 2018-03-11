package com.example.tcc.moviewoody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCinema extends AppCompatActivity  {
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private EditText editTextCinemaName;
    private EditText editTextCinemaCity;
    private EditText editTextCinemaLocation;
    private Button buttonAddCinema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cinema);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Cinema");

        editTextCinemaName = (EditText) findViewById(R.id.editTextCinemaName);
        editTextCinemaCity = (EditText) findViewById(R.id.editTextCinemaCity);
        editTextCinemaLocation = (EditText) findViewById(R.id.editTextCinemaLocation);
        buttonAddCinema = (Button) findViewById(R.id.buttonAddCinema);
        buttonAddCinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == buttonAddCinema) {
                    saveCinemaInformation();
                }

            }
        });
    }

    ////////////////////////////////////////////////////////////////////////
    public void saveCinemaInformation() {
        String name = editTextCinemaName.getText().toString().trim();
        String city = editTextCinemaCity.getText().toString().trim();
        String location = editTextCinemaLocation.getText().toString().trim();
        String id = databaseReference.push().getKey();

        CinemaInformation cinemaInformation = new CinemaInformation(name, city, location, id);


        if (TextUtils.isEmpty(name)) {
            // email is empty!
            Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(city)) {
            // email is empty!
            Toast.makeText(this, "Please enter city", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(location)) {
            // email is empty!
            Toast.makeText(this, "Please enter location", Toast.LENGTH_SHORT).show();
            return;
        }
        databaseReference.child(id).setValue(cinemaInformation);
        Toast.makeText(this, "Cinema is added", Toast.LENGTH_LONG).show();

    }
///////////////////////////////////////////////////
}