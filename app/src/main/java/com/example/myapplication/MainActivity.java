package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
RecyclerView colorRecyclerView;
ArrayList<ColorModel> modelArrayList;
ColorAdapter colorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorRecyclerView=findViewById(R.id.colorrecyclerview);

        CustomLinearLayoutManager layoutManager=new CustomLinearLayoutManager(this);
        modelArrayList=new ArrayList<ColorModel>();
        modelArrayList.add(new ColorModel("#000000","Color Black"));
        modelArrayList.add(new ColorModel("#ff0000","Color RED"));
        modelArrayList.add(new ColorModel("#00ff00","Color GREEN"));
        modelArrayList.add(new ColorModel("#0000ff","Color BLUE"));
        modelArrayList.add(new ColorModel("#0ff0f0","Color secondary"));
        modelArrayList.add(new ColorModel("#f0ff0f","Color Variant"));
        modelArrayList.add(new ColorModel("#f000f0","Color surface"));
        modelArrayList.add(new ColorModel("#0ffff0","Color secondary Variant"));
        Collections.shuffle(modelArrayList);
        colorAdapter=new ColorAdapter(this,modelArrayList);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        colorRecyclerView.setLayoutManager(layoutManager);
        PagerSnapHelper snapHelper=new PagerSnapHelper();
        snapHelper.attachToRecyclerView(colorRecyclerView);

        colorRecyclerView.setAdapter(colorAdapter);

        colorAdapter.setonclicklistener(new ColorAdapter.onclicklistener() {
            @SuppressLint("ShowToast")
            @Override
            public void oncityselelected(int position) {
                Toast.makeText(MainActivity.this,modelArrayList.get(position).getColorName(), Toast.LENGTH_SHORT).show();
            }
        });

        modelArrayList.add(new ColorModel("#000000","MUNAZZA FATMA"));
        colorAdapter.notifyDataSetChanged();
        for(int i=0;i<100;i++) {
            modelArrayList.add(new ColorModel("#000000", "MUNAZZA FATMA" + String.valueOf(i)));
            colorAdapter.notifyDataSetChanged();
        }
/*

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            colorRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                    Toast.makeText(MainActivity.this, String.valueOf(i) + " " + String.valueOf(i1) + " " + String.valueOf(i2) + " " + String.valueOf(i3), Toast.LENGTH_SHORT).show();

                   */
/* double deltaY = 0.5;
                    if (i2 < 0) {
                        view.setPivotX(view.getWidth());

                    } else{
                        view.setPivotX(0);
                    }
                    view.setPivotY(view.getHeight() *(int) deltaY);
                    view.setRotationY(45);*//*


                }
            });
        }
*/
    }
}
