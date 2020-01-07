package com.byfrunze.englishstep_by_step.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.byfrunze.englishstep_by_step.R;

public class IntroAdapter extends PagerAdapter {

    private Context context;
    private String[] headArr;
    private String[] descriptionArr;
    private int[] slide_image = {
            R.drawable.intro1,
            R.drawable.intro2,
            R.drawable.intro3,
            R.drawable.intro3
    };

    public IntroAdapter(Context context) {
        this.context = context;
    }

    public void setHeadArr(String[] headArr) {
        this.headArr = headArr;
    }

    public void setDescriptionArr(String[] descriptionArr) {
        this.descriptionArr = descriptionArr;
    }

    @Override
    public int getCount() {
        return slide_image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View view = layoutInflater.inflate(R.layout.intro_slide, container, false);

        ImageView slideImageView = view.findViewById(R.id.imageView);
        TextView slideHeading = view.findViewById(R.id.textViewIntroHeader);
        TextView slideDescription = view.findViewById(R.id.textViewIntroDescription);

        slideImageView.setImageResource(slide_image[position]);
        slideHeading.setText(headArr[position]);
        slideDescription.setText(descriptionArr[position]);
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
