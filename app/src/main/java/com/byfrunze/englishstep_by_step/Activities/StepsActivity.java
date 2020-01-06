package com.byfrunze.englishstep_by_step.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.byfrunze.englishstep_by_step.R;
import com.google.android.material.card.MaterialCardView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepsActivity extends AppCompatActivity {

    private int level;
    @BindView(R.id.cardViewStepBeg)
    MaterialCardView cardViewBeg;
    @BindView(R.id.cardViewStepEl)
    MaterialCardView cardViewEl;
    @BindView(R.id.cardViewStepPre)
    MaterialCardView cardViewPre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);
        ButterKnife.bind(this);
        level = getIntent().getIntExtra("level", 0);
        Log.i("TAG", "onCreate: " + level);
        switch (level){
            case 0:
                cardViewBeg.setVisibility(View.VISIBLE);
                cardViewEl.setVisibility(View.INVISIBLE);
                cardViewPre.setVisibility(View.INVISIBLE);
                break;
            case 1:
                cardViewBeg.setVisibility(View.GONE);
                cardViewEl.setVisibility(View.VISIBLE);
                cardViewPre.setVisibility(View.GONE);
                break;
            case 2:
                cardViewBeg.setVisibility(View.INVISIBLE);
                cardViewEl.setVisibility(View.INVISIBLE);
                cardViewPre.setVisibility(View.VISIBLE);
                break;

        }
    }
}
