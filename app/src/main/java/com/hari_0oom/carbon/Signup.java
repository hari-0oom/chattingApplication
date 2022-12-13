package com.hari_0oom.carbon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.hari_0oom.carbon.Models.Users; //ye import kia hai
import com.hari_0oom.carbon.databinding.ActivitySignupBinding;

public class Signup extends AppCompatActivity {
ActivitySignupBinding binding;

private FirebaseAuth auth;

FirebaseDatabase database;

ProgressDialog progressDialog;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignupBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        auth=FirebaseAuth.getInstance();

        database= FirebaseDatabase.getInstance();

        progressDialog= new ProgressDialog( Signup.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're creating your account");

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(binding.etEmail.getText().toString().isEmpty()){
                    binding.etEmail.setError("Enter your Email");
                    return;
                }
                if(binding.etPassword.getText().toString().isEmpty()){
                    binding.etPassword.setError("Enter your Password");
                    return;
                }
                if(binding.userName.getText().toString().isEmpty()){
                    binding.userName.setError("Enter your Username");
                    return;
                }
                progressDialog.show();

                auth.createUserWithEmailAndPassword(binding.etEmail.getText().toString(), binding.etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            Users user = new Users(binding.etEmail.getText().toString(),binding.userName.getText().toString(), binding.etPassword.getText().toString());
                            String id= task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(user);

                            Toast.makeText(Signup.this, "USer Created Successfully", Toast.LENGTH_SHORT).show();

                            Intent intent= new Intent(Signup.this, Login.class);
                            startActivity(intent);
                            finish();

                        }
                        else{
                            Toast.makeText(Signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    binding.tvAlreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent= new Intent(Signup.this, Login.class);
            startActivity(intent);
            finish();
        }
    });
    }
}