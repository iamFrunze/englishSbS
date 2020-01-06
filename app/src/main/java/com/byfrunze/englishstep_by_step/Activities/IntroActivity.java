package com.byfrunze.englishstep_by_step.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.byfrunze.englishstep_by_step.Adapters.IntroAdapter;
import com.byfrunze.englishstep_by_step.R;
import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)       ViewPager viewPager;
    @BindView(R.id.btnBackIntro)    TextView btnBackIntro;
    @BindView(R.id.btnNextIntro)    TextView btnNextIntro;
    @BindView(R.id.pageIndicator)   PageIndicatorView pageIndicatorView;
    @BindView(R.id.btnStart)        Button btnStart;
    private int countPage;
    private int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);
        btnBackIntro.setVisibility(View.INVISIBLE);
        btnBackIntro.setEnabled(false);
        btnStart.setVisibility(View.INVISIBLE);
        btnStart.setEnabled(false);

        IntroAdapter adapter = new IntroAdapter(this);
        adapter.setHeadArr(getResources().getStringArray(R.array.intro_slider_heading));
        adapter.setDescriptionArr(getResources().getStringArray(R.array.intro_slider_description));
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                pageIndicatorView.setSelection(position);

                if (position == 0) {
                    btnBackIntro.setVisibility(View.INVISIBLE);
                    btnBackIntro.setEnabled(false);
                    btnNextIntro.setVisibility(View.VISIBLE);
                    btnNextIntro.setEnabled(true);

                } else if (position == (countPage - 1)) {
                    btnBackIntro.setVisibility(View.VISIBLE);
                    btnBackIntro.setEnabled(true);
                    btnNextIntro.setVisibility(View.INVISIBLE);
                    btnNextIntro.setEnabled(false);
                    btnStart.setVisibility(View.VISIBLE);
                    btnStart.setEnabled(true);


                } else {
                    btnBackIntro.setVisibility(View.VISIBLE);
                    btnBackIntro.setEnabled(true);
                    btnNextIntro.setVisibility(View.VISIBLE);
                    btnNextIntro.setEnabled(true);

                }
                countPage = adapter.getCount();
                //Indicator
                pageIndicatorView.setCount(countPage);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void OnClickBackIntro(View view) {
        viewPager.setCurrentItem(currentPage - 1, true);
    }



    public void OnClickNextIntro(View view) {
        viewPager.setCurrentItem(currentPage + 1, true);

    }

    public void OnClickStart(View view) {
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
