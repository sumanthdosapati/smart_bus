package com.ds.bus;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    EditText email;
    Button back,forg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        email=findViewById(R.id.et_for_email);
        back=findViewById(R.id.btn_back);
        forg=findViewById(R.id.btn_reset_password);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b=new Intent(getApplicationContext(),Login.class);
                startActivity(b);
            }
        });
        forg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Password Reset instructions sent to your email",Toast.LENGTH_LONG).show();
            }
        });

    }
}