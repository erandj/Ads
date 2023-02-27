package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init(){
        navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.id_my_ads:
                Toast.makeText(this, "Pressed id My Ads", Toast.LENGTH_SHORT).show();

                break;

            case R.id.id_cars_ads:
                Toast.makeText(this, "Pressed id Cars", Toast.LENGTH_SHORT).show();

                break;

            case R.id.id_pc_ads:
                Toast.makeText(this, "Pressed id Pc", Toast.LENGTH_SHORT).show();

                break;

            case R.id.id_smartphone_ads:
                Toast.makeText(this, "Pressed id smartphone", Toast.LENGTH_SHORT).show();

                break;

            case R.id.id_dm_ads:
                Toast.makeText(this, "Pressed id dm", Toast.LENGTH_SHORT).show();

                break;

            case R.id.id_sign_up:
                Toast.makeText(this, "Pressed id sign up", Toast.LENGTH_SHORT).show();

                break;

            case R.id.id_sign_in:
                Toast.makeText(this, "Pressed id sign in", Toast.LENGTH_SHORT).show();

                break;

            case R.id.id_sign_out:
                Toast.makeText(this, "Pressed id sign out", Toast.LENGTH_SHORT).show();

                break;
        }
        return true;
    }
}