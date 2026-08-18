package com.example.mg04;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Launch the Kotlin Compose activity
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
        finish(); // Close this activity so the user doesn't go back to it
    }
}
