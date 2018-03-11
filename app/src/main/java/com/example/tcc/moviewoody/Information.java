

package com.example.tcc.moviewoody;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Information extends AppCompatActivity implements View.OnClickListener{


    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    //private TextView textViewUserEmail;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextAddress;
    private Button buttonSubmit;
    // private Button buttonLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        firebaseAuth =  FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        FirebaseUser user =firebaseAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        //textViewUserEmail = (TextView) findViewById(R.id.editTextEmail);

        editTextFirstName=(EditText)findViewById(R.id.editTextFirstName);
        //textViewUserEmail.setText("welcom "+user.getEmail());
        editTextLastName=(EditText)findViewById(R.id.editTextLastName);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        //buttonLogout = (Button) findViewById(R.id.buttonLogout);

        buttonSubmit.setOnClickListener(this);
        // buttonLogout.setOnClickListener(this);

    }
    private void saveUserInformtion(){
        String firstName= editTextFirstName.getText().toString();
        String lastName= editTextLastName.getText().toString();
        String address= editTextAddress.getText().toString();
        if(TextUtils.isEmpty(firstName)){
            Toast.makeText(this,"Please Enter Your First Name", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(lastName)){
            Toast.makeText(this, "Please Enter Your Last Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(address)){
            Toast.makeText(this, "Please Enter Your Address", Toast.LENGTH_SHORT).show();
            return;
        }

        userAfterRegisterationInformation userInformation = new userAfterRegisterationInformation(firstName,lastName,address);
        FirebaseUser user =firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).setValue(userInformation);
        Toast.makeText(this, "information saved ",Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), profileActivity.class));
    }

    @Override
    public void onClick(View view) {
        //if (view == buttonLogout ){
        // Toast.makeText(this, "Please Enter The Required Information", Toast.LENGTH_SHORT).show();
        // return;}
        // else
        //if(view== buttonLogout && editTextFirstName!=null && editTextLastName!=null && editTextAddress !=null){
        //firebaseAuth.signOut();
        //finish();

        if (view == buttonSubmit) {
            saveUserInformtion();
            //startActivity(new Intent(this, profileActivity.class));
        }
    }}


