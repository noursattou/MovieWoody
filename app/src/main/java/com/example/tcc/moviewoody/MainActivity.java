package com.example.tcc.moviewoody;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.lang.Object;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignup;
    private EditText editTextEmail;
    private EditText ediTextPassword;
    private TextView textViewSignin;
    // because it's an internet operation that takes time we use this to ask the user to wait:
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // to initialize firebaseAuth object and we use this Ob to register user to the server:
        firebaseAuth = FirebaseAuth.getInstance();
//user already logged in
        if(firebaseAuth.getCurrentUser()!= null){
            // start profile activity
            finish();
            startActivity(new Intent(getApplicationContext(),profileActivity.class));

        }



        progressDialog =new ProgressDialog(this);
        buttonSignup=(Button) findViewById(R.id.buttonSignup);
        editTextEmail=(EditText)findViewById(R.id.editTextEmail);
        ediTextPassword=(EditText)findViewById(R.id.editTextPassword);
        textViewSignin = (TextView)findViewById(R.id.textViewSignin);
        buttonSignup.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);}

    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextEmail.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            // email is empty!
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();return;}

        if(TextUtils.isEmpty(password)){
            // password is empty!
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show(); return;}
// if validations are ok
        progressDialog.setMessage("Registering..Please wait..");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {
                            // user is successfully registered and signed in
                            // we start the profile activity here
                            //Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            progressDialog.hide();
                            finish();
                            startActivity(new Intent(getApplicationContext(),profileActivity.class));}

                        else {Toast.makeText(MainActivity.this, "Registerstion failed .. Try again", Toast.LENGTH_SHORT).show();
                            progressDialog.hide();

                        }//else
                    }//oncomplete
                });
    }
    @Override
    public void onClick (View view) {
        if (view==buttonSignup){
            registerUser();
        }
        if (view==textViewSignin){
            startActivity(new Intent(this,LoginActivity.class));
        }


    }

}

