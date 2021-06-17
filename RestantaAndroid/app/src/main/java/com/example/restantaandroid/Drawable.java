package com.example.restantaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Drawable extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);

        btnBack = findViewById(R.id.button4);

        btnBack.setOnClickListener(view->{
            startActivity(new Intent(Drawable.this, MainActivity.class));
        });
    }
}