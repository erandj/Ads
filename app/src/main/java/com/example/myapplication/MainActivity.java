package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navView;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init(){
        navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
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

        EditText etEmail = dialogView.findViewById(R.id.etEmail);
        EditText etPassword = dialogView.findViewById(R.id.etPassword);

        Button signBtn = dialogView.findViewById(R.id.signButton);
        signBtn.setText(buttonTitle);

        AlertDialog dialog = dialogBuilder.create();
        dialog.show();

        if (title == R.string.sign_up){
            signBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    signUp(etEmail.getText().toString(), etPassword.getText().toString());
                }

            });

        }else if(title == R.string.sign_in){
            signBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    signIn(etEmail.getText().toString(), etPassword.getText().toString());
                }

            });
        }
    }

    private void signUp(String email, String password){
        if (email.equals("") && password.equals("")){
            Toast.makeText(this, "email or password empty", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        Log.d("MainActivity signUn", "Successful auth");
                    }else {
                        Toast.makeText(getApplicationContext(), "Authentification failed", Toast.LENGTH_SHORT).show();
                        Log.e("Log_my_MainActivity", "Error body: ", task.getException());
                    }
                }
            });
    }

    private void signIn(String email, String password){
        if (email.equals("") && password.equals("")){
            Toast.makeText(this, "email or password empty", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Log.d("MainActivity signIn", "Successful auth");
                        }else {
                            Toast.makeText(getApplicationContext(), "Authentification failed", Toast.LENGTH_SHORT).show();
                            Log.e("Log_my_MainActivity", "Error body: ", task.getException());
                        }
                    }
                });
    }

    private void signOut(){
        firebaseAuth.signOut();
    }
}