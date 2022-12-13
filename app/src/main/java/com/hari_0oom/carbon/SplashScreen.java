package com.hari_0oom.carbon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    ImageView naruto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        naruto=findViewById(R.id.naruto);
        naruto.animate().rotationY(360).rotationX(360).setDuration(500);

        getSupportActionBar().hide();
        Thread thread= new Thread(){
            public void run(){
                try{
                    sleep(650);

                }catch(Exception e){

                }finally{
                    Intent intent=new Intent(SplashScreen.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }

        };
        thread.start();
    }
}