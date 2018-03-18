package com.example.tcc.moviewoody;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CinemaInCity extends AppCompatActivity {

public static final String DATABASE_PATH= "Cinemas";

    ListView listViewCinemas;
    List<String> list;
    myAdapter2 myAdapter;
    DatabaseReference databaseReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_in_city);
        listViewCinemas = (ListView) findViewById(R.id.listViewCinemas);
        list = new ArrayList<>();
        databaseReference= FirebaseDatabase.getInstance().getReference("Cinemas");
//databaseReference= FirebaseDatabase.getInstance().getReference(DATABASE_PATH);
        String value = getIntent().getExtras().getString("cinemaName");
       // Toast.makeText(CinemaInCity.this, "You chose: "+value, Toast.LENGTH_LONG).show();
      // Query q=  databaseReference.child(DATABASE_PATH);
               //.child("cityName").equalTo(value);

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = getIntent().getExtras().getString("cinemaName");

               // Toast.makeText(CinemaInCity.this, "You chose: "+value, Toast.LENGTH_LONG).show();
                list.clear();
String str="";
                for (DataSnapshot snap : dataSnapshot.getChildren() ) {
                    if (snap.child("cityName").getValue().toString().equals(value))
                   str = snap.child("cinemaName").getValue().toString();
                    Toast.makeText(CinemaInCity.this, " "+str, Toast.LENGTH_SHORT).show();

                    // Cinema cinema = snap.getValue(Cinema.class);

                }
                list.add(str);
                myAdapter = new myAdapter2(CinemaInCity.this, list);
                listViewCinemas.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }







}
