package com.example.tcc.moviewoody;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.Intent;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddMovie extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

  /*  private TextView movieName;
    private TextView Genre;
    private TextView duration;*/

    private EditText editTextMovieName;
    private EditText editTextGenre;
    private EditText editTextDuration;
    private Button buttonAddMovie;



    ListView listViewCinemas;
    List<Cinema> list;
    myAdapter2 myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Movie");
       /* movieName=(TextView) findViewById(R.id.textViewMovieName);
        Genre=(TextView) findViewById(R.id.textViewGenre);
        duration=(TextView) findViewById(R.id.textViewDuration);*/
        editTextMovieName = (EditText) findViewById(R.id.editTextMovieName);
        editTextGenre = (EditText) findViewById(R.id.editTextGenre);
        editTextDuration = (EditText) findViewById(R.id.editTextDuration);
        buttonAddMovie = (Button) findViewById(R.id.buttonAddMovie);
        listViewCinemas = (ListView) findViewById(R.id.listViewCinemas);
        list = new ArrayList<>();



        buttonAddMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == buttonAddMovie) {
                    saveMovieInformation();
                }

            }
        });

    }

    ////////////////////////////////////
    public void saveMovieInformation() {
        String name = editTextMovieName.getText().toString().trim();
        String genre = editTextGenre.getText().toString().trim();
        String duration = editTextDuration.getText().toString().trim();
        String id=databaseReference.push().getKey();

        MovieInformation movieInformation = new MovieInformation(name, genre, duration,id);


        if (TextUtils.isEmpty(name)) {
            // email is empty!
            Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(genre)) {
            // email is empty!
            Toast.makeText(this, "Please enter genre", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(duration)) {
            // email is empty!
            Toast.makeText(this, "Please enter duration", Toast.LENGTH_SHORT).show();
            return;
        }
        databaseReference.child(id).setValue(movieInformation);
        Toast.makeText(this, "Movie is added", Toast.LENGTH_LONG).show();

    }
    ///////////////////////////////////////////////////
    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //progressDialog.dismiss();
                list.clear();
                for (DataSnapshot snap : dataSnapshot.getChildren() ){
                    Cinema cinema = snap.getValue(Cinema.class);
                    list.add(cinema);
                }
               // myAdapter = new myAdapter2(AddMovie.this, list);
               // listViewCinemas.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }







}