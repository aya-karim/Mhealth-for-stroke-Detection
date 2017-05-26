package com.example.shoo.gptrial2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SignINActivity extends AppCompatActivity {

    EditText mail;
    EditText password;
    CheckBox rememberMe;
    public static final String dEFAULT= "N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Toast.makeText(getApplicationContext(),"activity created",Toast.LENGTH_LONG).show();
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor=prefs.edit();
        String restoredText = prefs.getString("mail",dEFAULT);
        String restoredPass = prefs.getString("password",dEFAULT);

        rememberMe=(CheckBox)findViewById(R.id.cbRememberMe);
        mail = (EditText)findViewById(R.id.txtSignInMail);
        password = (EditText)findViewById(R.id.signInpassword);

        if(restoredPass.equals(dEFAULT) || restoredText.equals(dEFAULT)){
            Toast.makeText(this,restoredText,Toast.LENGTH_LONG).show();
            Toast.makeText(this,restoredPass,Toast.LENGTH_LONG).show();
        }
        else{
            mail.setText(restoredText);
            password.setText(restoredPass);
        }

        String isRemembered;
        if(rememberMe.isChecked())
            isRemembered="t";
        else
            isRemembered="f";

        editor.putString("rememberMe",isRemembered);
        editor.commit();

    }

    public void load(View view){


       Toast.makeText(this,"Gowa el-load",Toast.LENGTH_LONG).show();



    }
}
