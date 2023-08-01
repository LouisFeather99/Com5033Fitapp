package com.example.healthandfitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindTrainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_trainer);

        CardView exit = findViewById(R.id.cardBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindTrainerActivity.this,HomeActivity.class));
            }
        });

        CardView physiquetrainer = findViewById(R.id.cardPhysiqueTrainer);
        physiquetrainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindTrainerActivity.this,TrainerDetailsActivity.class);
                it.putExtra("title","Physique Trainer");
                startActivity(it);
            }
        });

        CardView strengthtrainer = findViewById(R.id.cardStrengthTrainer);
        strengthtrainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindTrainerActivity.this,TrainerDetailsActivity.class);
                it.putExtra("title","Strength Trainer");
                startActivity(it);
            }
        });

        CardView performancetrainer = findViewById(R.id.cardPerformanceTrainer);
        performancetrainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindTrainerActivity.this, TrainerDetailsActivity.class);
                it.putExtra("title", "Performance Trainer");
                startActivity(it);

            }


        });

        CardView lifestylecoach = findViewById(R.id.cardLifestyleCoach);
        lifestylecoach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindTrainerActivity.this, TrainerDetailsActivity.class);
                it.putExtra("title", "Lifestyle Coach");
                startActivity(it);

            }


        });


        CardView fitnesstrainer = findViewById(R.id.cardFitnessTrainer);
        fitnesstrainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindTrainerActivity.this, TrainerDetailsActivity.class);
                it.putExtra("title", "Fitness Trainer");
                startActivity(it);

            }


        });
    }
}
