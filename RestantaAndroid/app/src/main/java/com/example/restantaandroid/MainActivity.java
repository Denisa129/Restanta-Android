package com.example.restantaandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    FirebaseAuth mAuth;
    Button btnLogOut;
    Button btnDrawable;
    String s1[], s2[];
    int images[] = {R.drawable.dog, R.drawable.cat, R.drawable.elephant, R.drawable.frog,
    R.drawable.mouse, R.drawable.giraffe, R.drawable.lion};
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1= getResources().getStringArray(R.array.animals);
        s2= getResources().getStringArray(R.array.description);
        recyclerView = findViewById(R.id.recyclerView);

        MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAuth= FirebaseAuth.getInstance();
        btnLogOut = findViewById(R.id.button);
        btnDrawable = findViewById(R.id.button2);

        btnLogOut.setOnClickListener(view->{
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });

        btnDrawable.setOnClickListener(view->{

            startActivity(new Intent(MainActivity.this, Drawable.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }

    }
}