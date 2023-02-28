package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

        // Write a message to the database

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("table");

        myRef.setValue("Hello, World!");
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
                signDialog(R.string.sign_up, R.string.sign_up_btn);
                Toast.makeText(this, "Pressed id sign up", Toast.LENGTH_SHORT).show();
                break;

            case R.id.id_sign_in:
                signDialog(R.string.sign_in, R.string.sign_in_btn);
                Toast.makeText(this, "Pressed id sign in", Toast.LENGTH_SHORT).show();
                break;

            case R.id.id_sign_out:
                Toast.makeText(this, "Pressed id sign out", Toast.LENGTH_SHORT).show();

                break;
        }
        return true;
    }

    private void signDialog(int title, int buttonTitle){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.layout_sign_up, null);

        dialogBuilder.setView(dialogView);

        TextView signTitle = dialogView.findViewById(R.id.tvSignTitle);
        signTitle.setText(title);

        Button signBtn = dialogView.findViewById(R.id.signButton);
        signBtn.setText(buttonTitle);

        AlertDialog dialog = dialogBuilder.create();
        dialog.show();

        if (title == R.string.sign_up){
            signBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "sign up", Toast.LENGTH_SHORT).show();
                }

            });

        }else if(title == R.string.sign_in){
            signBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "sign in", Toast.LENGTH_SHORT).show();
                }

            });
        }
    }
}