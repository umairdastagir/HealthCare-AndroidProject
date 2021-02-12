package com.example.healthcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

public class Adapter_Tutorial extends PagerAdapter {
    private List<Model_Tutorial> model;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter_Tutorial(List<Model_Tutorial> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater= LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.tutorial_item,container,false);
        LottieAnimationView imgTut;
        TextView txtTutTitle;
        CardView cardColor;
        cardColor= view.findViewById(R.id.cardBackColor);
        imgTut = view.findViewById(R.id.tutImage);
        txtTutTitle= view.findViewById(R.id.tutTitle);

        //imgTut.setImageResource(model.get(position).getCardImage());

        //cardColor.setBackgroundResource(model.get(position).getCardBackgroud());
        imgTut.setAnimation(model.get(position).getCardImage());
        txtTutTitle.setText(model.get(position).getTitle());
        container.addView(view,0);

        return view;
    }



    @NonNull
    @Override
    public Object instantiateItem(@NonNull View container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
