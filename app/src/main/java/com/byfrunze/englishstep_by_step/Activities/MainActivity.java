package com.byfrunze.englishstep_by_step.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.byfrunze.englishstep_by_step.R;
import com.google.android.material.card.MaterialCardView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cardViewBeginner)
    MaterialCardView cardViewBeginner;
    @BindView(R.id.cardViewElementary)
    MaterialCardView cardViewElementary;
    @BindView(R.id.cardViewPreIntermediate)
    MaterialCardView cardViewPreIntermediate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        cardViewBeginner.setOnClickListener(v -> startStepsBeginner());
        cardViewElementary.setOnClickListener(v -> startStepsElementary());
        cardViewPreIntermediate.setOnClickListener(v -> startStepsPreIntermediate());
    }

    public void startStepsBeginner(){
        Intent intent = new Intent(MainActivity.this, StepsActivity.class);
        intent.putExtra("level", 0);
        String transitionName = getString(R.string.transition_beginner);
        View viewStart = cardViewBeginner;
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(MainActivity.this, viewStart, transitionName);
        ActivityCompat.startActivity(MainActivity.this, intent, optionsCompat.toBundle());
    }
    public void startStepsElementary(){
        Intent intent = new Intent(MainActivity.this, StepsActivity.class);
        intent.putExtra("level", 1);
        String transitionName = getString(R.string.transition_elementary);
        View viewStart = cardViewElementary;
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(MainActivity.this, viewStart, transitionName);
        ActivityCompat.startActivity(MainActivity.this, intent, optionsCompat.toBundle());
    }
    public void startStepsPreIntermediate(){
        Intent intent = new Intent(MainActivity.this, StepsActivity.class);
        intent.putExtra("level", 2);
        String transitionName = getString(R.string.transition_pre);
        View viewStart = cardViewPreIntermediate;
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(MainActivity.this, viewStart, transitionName);
        ActivityCompat.startActivity(MainActivity.this, intent, optionsCompat.toBundle());
    }
}
