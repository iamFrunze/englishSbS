package com.byfrunze.englishstep_by_step.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.SearchView;

import com.byfrunze.englishstep_by_step.R;
import com.google.android.material.card.MaterialCardView;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.Value;
import com.rd.animation.type.SlideAnimation;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cardViewBeginner)
    MaterialCardView cardViewBeginner;
    @BindView(R.id.cardViewElementary)
    MaterialCardView cardViewElementary;
    @BindView(R.id.cardViewPreIntermediate)
    MaterialCardView cardViewPreIntermediate;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentTransition();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("English Step-by-Step");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        cardViewBeginner.setOnClickListener(v -> startStepsBeginner());
        cardViewElementary.setOnClickListener(v -> startStepsElementary());
        cardViewPreIntermediate.setOnClickListener(v -> startStepsPreIntermediate());

    }

    private void setContentTransition(){
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setAllowEnterTransitionOverlap(true);
        getWindow().setAllowReturnTransitionOverlap(true);
        Explode explode = new Explode();
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(800);
        explode.setDuration(800);
        getWindow().setSharedElementExitTransition(changeBounds);
        getWindow().setExitTransition(explode);
        getWindow().setReenterTransition(explode);

    }

    public void startStepsBeginner(){
        Intent intent = new Intent(MainActivity.this, StepsActivity.class);
        intent.putExtra("level", 0);
        String transitionName = getString(R.string.transition_beginner);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(MainActivity.this, cardViewBeginner, transitionName);
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
