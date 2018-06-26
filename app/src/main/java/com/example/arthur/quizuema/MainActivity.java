package com.example.arthur.quizuema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.arthur.quizuema.DAO.CriarBD;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        CriarBD banco = new CriarBD(getApplicationContext());
    }

    public void btnJogarOnClick(View v) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}
