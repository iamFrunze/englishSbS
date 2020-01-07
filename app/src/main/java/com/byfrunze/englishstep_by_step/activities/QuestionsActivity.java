package com.byfrunze.englishstep_by_step.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.widget.TextView;

import com.byfrunze.englishstep_by_step.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionsActivity extends AppCompatActivity {

    @BindView(R.id.textViewStep)
    TextView textViewStep;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentTransition();
        setContentView(R.layout.activity_questions);
        ButterKnife.bind(this);
        toolbar.setTitle("Questions");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp));
        setSupportActionBar(toolbar);

        String step = getIntent().getStringExtra("step");
        textViewStep.setText(step);
    }

    private void setContentTransition() {
        Slide slideL = new Slide(Gravity.START);
        Explode explode = new Explode();
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(1000);
        explode.setDuration(1000);
        slideL.setDuration(1000);
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setAllowEnterTransitionOverlap(true);
        getWindow().setAllowReturnTransitionOverlap(true);
        Log.i("GO", "setContentTransition: " + "QA ");

        getWindow().setSharedElementEnterTransition(changeBounds);
        getWindow().setEnterTransition(slideL);
        getWindow().setReturnTransition(explode);                                        //уход QustionsActivity
//
//        //уход
//        getWindow().setSharedElementExitTransition(new ChangeBounds());
//        getWindow().setExitTransition(explode);
//        getWindow().setReenterTransition(slideU);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
