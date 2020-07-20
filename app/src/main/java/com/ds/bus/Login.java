package com.ds.bus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email,pass;
    Button log,reg,forg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.useredit);
        pass=findViewById(R.id.passedit);

        log=findViewById(R.id.clibutton);
        reg=findViewById(R.id.register);
        forg=findViewById(R.id.forpass);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r=new Intent(getApplicationContext(),Register.class);
                startActivity(r);
            }
        });
        forg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f=new Intent(getApplicationContext(),ForgotPassword.class);
                startActivity(f);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  if((email.getText().toString()=="user")&&(pass.getText().toString()=="user"))
              //  {
                    Intent i1=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i1);
                Toast.makeText(getApplicationContext(), "Authentication after creating database", Toast.LENGTH_LONG).show();
               // }
            }
        });


    }
}