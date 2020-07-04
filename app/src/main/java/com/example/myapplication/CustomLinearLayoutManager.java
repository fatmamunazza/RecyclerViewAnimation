package com.example.myapplication;


import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomLinearLayoutManager extends LinearLayoutManager {

    private final float mShrinkAmount = 0.15f;
    private final float mShrinkDistance = 1.0f;

    public CustomLinearLayoutManager(Context context) {
        super(context);
    }

   /* @Override
    public int scrollVerticallyBy(int dy, @NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        int orientation = getOrientation();
        if (orientation == VERTICAL) {
            int scrolled = super.scrollVerticallyBy(dy, recycler, state);
            float midpoint = getHeight() / 2.0f;
            float d0 = 0.0f;
            float d1 = mShrinkDistance * midpoint;
            float s0 = 1.0f;
            float s1 = 1.0f - mShrinkAmount;
            // loop through active children and set scale of child
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                float childMidpoint = (getDecoratedBottom(child) + getDecoratedTop(child)) / 2.0f;
                float d = Math.min(d1, Math.abs(midpoint - childMidpoint));
                float scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0);
                child.setScaleX(scale);
                child.setScaleY(scale);
            }
            return scrolled;
        } else {
            return 0;
        }
    }
*/
    //Carossel animation for recyclerview
   /* @Override
    public int scrollHorizontallyBy(int dx, @NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        int orientation = getOrientation();
        if (orientation == HORIZONTAL) {
            int scrolled = super.scrollHorizontallyBy(dx, recycler, state);
            float midpoint = getWidth() / 2.0f;
            float d0 = 0.0f;
            float d1 = mShrinkDistance * midpoint;
            float s0 = 1.0f;
            float s1 = 1.0f - mShrinkAmount;
            // loop through active children and set scale of child
            if(getChildCount()==1){
                View child = getChildAt(0);
                child.setScaleX(1);
                child.setScaleY(1);
            }
            if(getChildCount()==2) {
                for (int i = 0; i < getChildCount(); i++) {
                    int k = 0;
                    View child = getChildAt(i);
                    float childMidpoint = (getDecoratedRight(child) + getDecoratedLeft(child)) / 2.0f;
                    float d = Math.min(d1, Math.abs(midpoint - childMidpoint));
                    float scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0);
                     child.setScaleX(scale);
                     child.setScaleY(scale);
                }
            }
            return scrolled;
        } else {
            return 0;
        }
    }
*/
    //IGTV animation for recyclerview
    @Override
    public int scrollHorizontallyBy(int dx, @NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        int orientation = getOrientation();
        if (orientation == HORIZONTAL) {
            int scrolled = super.scrollHorizontallyBy(dx, recycler, state);
            if(getChildCount()==1){
                View child = getChildAt(0);
                child.setScaleX(1);
                child.setScaleY(1);
                child.setRotationY(0);
            }
            if(getChildCount()==2) {
                for (int i = 0; i < getChildCount(); i++) {
                    View child = getChildAt(i);
                    int position;
                    if (i == 1) {
                        position = getDecoratedLeft(child);
                    } else {
                        position =-getDecoratedRight(child)+getDecoratedLeft(child);
                    }
                    if((float) position / 1080!=-1.0 && (float) position / 1080!=0) {
                        child.setScaleY(1-(float) (getDecoratedRight(child)-1080)/1080);
                        child.setPivotY(child.getHeight() /2);
                    }
                    if (position / 1080 < 0) {
                        child.setPivotX(child.getWidth());
                    } else {
                        child.setPivotX(0);
                        child.setScaleY(1);
                    }
                    child.setRotationY(30 * getDecoratedLeft(child) / 1080);
                }
            }
            return scrolled;
        } else {
            return 0;
        }
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        scrollVerticallyBy(0, recycler, state);
    }
}

