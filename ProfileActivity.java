package com.example.aditya.androidphpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView textViewUsername,textViewUseremail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        if(!SharedPrefManager.getInstance(this).isLoggedIn())
        {
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        textViewUsername=(TextView) findViewById(R.id.textViewUsername);
        textViewUseremail=(TextView) findViewById(R.id.textViewEmail);
        textViewUsername.setText(SharedPrefManager.getInstance(this).getUsername());
        textViewUseremail.setText(SharedPrefManager.getInstance(this).getUseremail());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menuLogout:SharedPrefManager.getInstance(this).logout();
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;

        }
        return true;
    }
}
