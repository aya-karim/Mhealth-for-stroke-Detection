package com.example.shoo.gptrial2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path = " ";
     //   gptest.fileReader r= new gptest.fileReader(path);

        //HomePage
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        String restoredText = prefs.getString("rememberMe",null);

        if(restoredText=="t")
        {
            Intent i= new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(i);
        }


        //SignUp
        Button signUp = (Button) findViewById(R.id.btnSignUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , SignUpActivity.class);
                startActivity(i);
            }
        });

        //SignIn
        Button signIn = (Button) findViewById(R.id.btnSignIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SignINActivity.class);
                startActivity(i);
            }
        });


    }
}
