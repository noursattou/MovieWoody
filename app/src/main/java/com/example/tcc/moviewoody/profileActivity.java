package com.example.tcc.moviewoody;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class profileActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonSearch;
    private Button buttonLogout;
    private Button buttonReserve;

    private FirebaseAuth firebaseAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        if ( firebaseAuth.getCurrentUser()== null){// he is not logged in
            finish();
            startActivity(new Intent(this , LoginActivity.class));

        }

        FirebaseUser  user = firebaseAuth.getCurrentUser();


         buttonReserve = (Button) findViewById(R.id.buttonReserve);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        buttonLogout= (Button) findViewById(R.id.buttonLogout);

        buttonReserve.setOnClickListener(this);
        buttonSearch.setOnClickListener(this);
        buttonLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonLogout){
            firebaseAuth.signOut();
            startActivity(new Intent(this, LoginActivity.class));
        }

if(view==buttonReserve){
    finish();
    startActivity(new Intent(this, Reservation.class));


}
 else if (view==buttonSearch){
 finish();
    startActivity(new Intent(this, Search.class));


}

    }
}





