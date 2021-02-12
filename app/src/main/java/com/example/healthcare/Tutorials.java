package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthcare.Activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class Tutorials extends AppCompatActivity {
    ViewPager viewPager;
    Adapter_Tutorial adapter_tutorial;
    List<Model_Tutorial> models;
    Integer[] colors= null;
    ArgbEvaluator argbEvaluator;
    Button btnTutorial;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials);
        viewPager = findViewById(R.id.viewPager);
        argbEvaluator= new ArgbEvaluator();
        btnTutorial= findViewById(R.id.btnTutorial);

        btnTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tutorials.this, MainActivity.class));
                finish();
            }
        });


        models = new ArrayList<>();
        models.add(new Model_Tutorial(R.raw.doc_talk,"Connect With Doctors Easily"));
        models.add(new Model_Tutorial(R.raw.get_posts,"All Health Problems Answered At A Single Platform"));
        models.add(new Model_Tutorial(R.raw.doc_patient,"Get Your Health Issues Checked By Verified Doctors"));
        models.add(new Model_Tutorial(R.raw.get_started,"Welcome To The Community"));

        adapter_tutorial= new Adapter_Tutorial(models,Tutorials.this);

        Integer[] color_temp = {
                getResources().getColor(R.color.bnv_color),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };
        colors = color_temp;
        viewPager.setAdapter(adapter_tutorial);
        viewPager.setPadding(130,0,130,0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter_tutorial.getCount()) - 1 && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor((
                                    (Integer) argbEvaluator.evaluate(
                                            positionOffset,
                                            colors[position],
                                            colors[position + 1])
                            )
                    );
                }else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);}
            }


            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
