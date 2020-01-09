package com.byfrunze.englishstep_by_step.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.byfrunze.englishstep_by_step.adapters.StepsAdapter;
import com.byfrunze.englishstep_by_step.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

import static androidx.core.app.ActivityOptionsCompat.*;

public class StepsActivity extends AppCompatActivity {

    @BindView(R.id.cardViewStepBeg)
    MaterialCardView cardViewBeg;
    @BindView(R.id.cardViewStepEl)
    MaterialCardView cardViewEl;
    @BindView(R.id.cardViewStepPre)
    MaterialCardView cardViewPre;
    @BindView(R.id.recycleViewSteps)
    RecyclerView recyclerViewSteps;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentTransition();
        setContentView(R.layout.activity_steps);
        getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
        ButterKnife.bind(this);
        toolbar.setTitle("Steps");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp));
        setSupportActionBar(toolbar);
        int level = getIntent().getIntExtra("level", 0);
        changeLevel(level);
        recyclerViewSteps.setLayoutManager(new LinearLayoutManager(this));
        List<String> test = testSteps();
        StepsAdapter adapter = new StepsAdapter(test);
        recyclerViewSteps.setAdapter(adapter);
        adapter.setOnItemClickListener((pos, cardView, textViewTitle, textViewDesc) -> {
            Intent intent = new Intent(StepsActivity.this, QuestionsActivity.class);
            intent.putExtra("level", 0);
            intent.putExtra("stepTitle", textViewTitle.getText());
            intent.putExtra("stepDesc", textViewDesc.getText());
            String transitionNameCV = getString(R.string.transition_card_view_step);
            String transitionNameTV = "StepTitle";
            String transitionNameTVDesc = "StepDesc";




            ActivityOptionsCompat optionsCompat = makeSceneTransitionAnimation(StepsActivity.this,
                    new Pair<>(cardView, transitionNameCV),
                    new Pair<>(textViewTitle, transitionNameTV),
                    new Pair<>(textViewDesc, transitionNameTVDesc));
            ActivityCompat.startActivity(StepsActivity.this, intent, optionsCompat.toBundle());
        });
        adapter.setOnItemLongClickListener( (pos, cardView) -> {
            cardView.setElevation(15);
        });

    }

    public List<String> testSteps() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Step " + i);
        }
        return list;
    }

    private void changeLevel(int lvl) {
        switch (lvl) {
            case 0:
                cardViewBeg.setVisibility(View.VISIBLE);
                cardViewEl.setVisibility(View.GONE);
                cardViewPre.setVisibility(View.GONE);
                break;
            case 1:
                cardViewBeg.setVisibility(View.GONE);
                cardViewEl.setVisibility(View.VISIBLE);
                cardViewPre.setVisibility(View.GONE);
                break;
            case 2:
                cardViewBeg.setVisibility(View.GONE);
                cardViewEl.setVisibility(View.GONE);
                cardViewPre.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void setContentTransition() {

        Explode explode = new Explode();
        explode.setDuration(800);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(800);

        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
//        getWindow().setSharedElementEnterTransition(set);
        getWindow().setAllowEnterTransitionOverlap(true);
        getWindow().setAllowReturnTransitionOverlap(true);


        getWindow().setEnterTransition(explode);
        getWindow().setReturnTransition(explode);
//
//        //уход
        getWindow().setSharedElementExitTransition(changeBounds);
        getWindow().setExitTransition(explode);
        getWindow().setReenterTransition(explode);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
