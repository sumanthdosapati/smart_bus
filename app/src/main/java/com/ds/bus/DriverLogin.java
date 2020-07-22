package com.ds.bus;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DriverLogin extends AppCompatActivity {

    EditText id,pw;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);

        id=findViewById(R.id.driveridet);
        pw=findViewById(R.id.driverpasset);
        login=findViewById(R.id.dloginbut);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((id.getText().toString()=="123")&&(pw.getText().toString()=="123"))
                {
                    Intent i1=new Intent(getApplicationContext(),QRcodeScanner.class);
                    startActivity(i1);
                }
            }
        });

    }
}