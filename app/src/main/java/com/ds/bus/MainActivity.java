package com.ds.bus;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    EditText sour,dest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange)));

        sour=findViewById(R.id.source_et);
        dest=findViewById(R.id.destination_et);
        final String source=sour.getText().toString();
        final String destination=dest.getText().toString();
        Button book=findViewById(R.id.book_btn);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if((sour.getText().toString().isEmpty()) || dest.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Source or Destination cannot be empty",Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent myIntent = new Intent(getApplicationContext(), No_of_tickets.class);
                    myIntent.putExtra("selected_source", source);
                    myIntent.putExtra("selected_destination", destination);
                    startActivity(myIntent);
                }
            }
        });


        drawerLayout=(DrawerLayout) findViewById(R.id.dlout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView=(NavigationView) findViewById(R.id.nvview);
        View headerView = navigationView.getHeaderView(0);
       // TextView navmail = (TextView) headerView.findViewById(R.id.hedermail);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id) {
                    case R.id.action_book:
                        Intent bo = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(bo);
                        break;

                    case R.id.action_history:
                        Intent hi = new Intent(getApplicationContext(), MyBookings.class);
                        startActivity(hi);
                        break;

                    case R.id.action_wallet:
                        Toast.makeText(getApplicationContext(),"Wallet coming soon..",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_developers:
                        Toast.makeText(getApplicationContext(),"Developed with ♥ by team xyz",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_live:
                        Intent ma = new Intent(getApplicationContext(), CommunityChat.class);
                        startActivity(ma);
                        break;


                    case R.id.action_share:
                        shareTextUrl();
                        break;

                    case R.id.action_rate:
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("market://details?id=com.ds.bus")));
                        } catch (android.content.ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://play.google.com/store/apps/details?id=com.ds.bus")));
                        }
                        break;

                    case R.id.action_suggest:
                        Intent dv= new Intent(getApplicationContext(),Suggestions.class);
                        startActivity(dv);
                        break;

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            }
        });







    }






    private void shareTextUrl() {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, "Now Travel");
        share.putExtra(Intent.EXTRA_TEXT, "http://play.google.com/store/apps/details?id=com.ds.bus");

        startActivity(Intent.createChooser(share, "Share Now Travel app"));

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit");
        builder.setIcon(R.drawable.yellowbusround);
        builder.setMessage("Do you want to Exit")
                .setCancelable(false)
                .setPositiveButton("YES",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.threedots, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }


}