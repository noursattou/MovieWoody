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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
public class Search extends AppCompatActivity  implements View.OnClickListener {
    Button buttonSearchCity;
    ListView listViewCity;
final List<Cinema> list = new ArrayList<>() ;
MyAdapter myAdapter;
DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        buttonSearchCity = (Button) findViewById(R.id.buttonSearchCity);
        listViewCity = (ListView) findViewById(R.id.listViewCity);

        buttonSearchCity.setOnClickListener(this);
       // list = new ArrayList<>();
        databaseReference= FirebaseDatabase.getInstance().getReference("Cinemas");




listViewCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
Intent intent = new Intent(Search.this,CinemaInCity.class);
intent.putExtra("cinemaName",list.get(i).cityName);
//String value = list.get(i).toString();

//intent.putExtra("Cinemas in ",listViewCity.getItemAtPosition(i).toString());
        //Toast.makeText(Search.this, "You chose: "+value, Toast.LENGTH_LONG).show();

        startActivity(intent);
    }
});
    }


    @Override
    public void onClick(View view) {
//if (view==buttonSearchCity)

    }

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
                myAdapter = new MyAdapter(Search.this, list);
                listViewCity.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }


}