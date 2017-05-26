package com.example.shoo.gptrial2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import libsvm.svm;

public class SignUpActivity extends AppCompatActivity {

    EditText mail;
    EditText password;
    EditText age;
    EditText phone;
    EditText name;
    EditText eContact1;
    EditText eContact2;

    RadioButton female;
    RadioButton male;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //male.setChecked(true);

        mail = (EditText) findViewById(R.id.txtEmail);
        password = (EditText) findViewById(R.id.txtPassword);
        name = (EditText) findViewById(R.id.txtNamw);
        age = (EditText) findViewById(R.id.txtAge);
        phone = (EditText) findViewById(R.id.txtPhone);
        eContact1 = (EditText) findViewById(R.id.txtEcontact1);
        eContact2 = (EditText) findViewById(R.id.txtEcontact2);
        female = (RadioButton) findViewById(R.id.btnFemal);
        male = (RadioButton) findViewById(R.id.btnMale);

        Button signUp= (Button)findViewById(R.id.btnCreat);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gender;
                if(female.isChecked())
                    gender="f";
                else
                    gender="m";

                SharedPreferences prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("mail", mail.getText().toString());
                editor.putString("password", password.getText().toString());
                editor.putString("age", age.getText().toString());
                editor.putString("name", name.getText().toString());
                editor.putString("econtact1", eContact1.getText().toString());
                editor.putString("econtact2", eContact2.getText().toString());
                editor.putString("phone", phone.getText().toString());
                editor.putString("gender", gender);

                editor.commit();

                Toast.makeText(SignUpActivity.this, "Saved", Toast.LENGTH_SHORT).show();

                AssetManager am = getApplicationContext().getAssets();

                InputStream is=null;
                try {
                    is = am.open("bla");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                File modelFile = creatFile(is);
                String path = modelFile.getAbsolutePath();
                //Toast.makeText(SignUpActivity.this, path, Toast.LENGTH_LONG).show();

                String dir = SignUpActivity.this.getFilesDir().getAbsolutePath();
                Toast.makeText(SignUpActivity.this, dir, Toast.LENGTH_LONG).show();

                libsvm.svm_model model = null;
                try {
                    Toast.makeText(SignUpActivity.this, "2bl el load", Toast.LENGTH_SHORT).show();
                    model = svm.svm_load_model(dir);
                    Toast.makeText(SignUpActivity.this, "b3d el load", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

                Intent i = new Intent(getApplicationContext(),SignINActivity.class);
                startActivity(i);





            }
        });


    }

    public void SignUp(View view) {

        Toast.makeText(this, "e7na filButton", Toast.LENGTH_SHORT).show();
    }

    private File creatFile(InputStream inputStream){
        File f = null;
        try{
            f = new File("output");
            OutputStream outPut = new FileOutputStream(f);
            byte buffer[] = new byte[1024];
            int length = 0;

            while((length=inputStream.read(buffer)) > 0) {
                outPut.write(buffer,0,length);
            }

            outPut.close();
            inputStream.close();

            return f;
        }catch (IOException e) {
            //Logging exception
            e.printStackTrace();
        }

        return f;
    }
}

