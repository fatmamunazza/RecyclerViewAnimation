package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder>{
    private Context mcontext;
    private onclicklistener mlistener;
    private ArrayList<ColorModel> marraylist;
    public interface onclicklistener{
        public void oncityselelected(int position);
    }
    public void setonclicklistener(onclicklistener listener){
        this.mlistener=listener;
    }
    public ColorAdapter(Context context, ArrayList<ColorModel> arrayList){
        this.mcontext=context;
        this.marraylist=arrayList;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.itemforcolorrecyclerview,parent,false);
        return new ColorViewHolder(view,mlistener);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        ColorModel obj=marraylist.get(position);
        holder.color.setText(obj.getColorName());
        holder.layout.setBackgroundColor(Color.parseColor(obj.getColor()));
       // setAnimation(holder.itemView,holder.itemView.getWidth());
       // Toast.makeText(mcontext, holder.itemView.getMeasuredWidthAndState(), Toast.LENGTH_SHORT).show();
    }
    private int lastPosition=-1;
    private void setAnimation(View view,int position){
       /* double deltaY = 0.5;
        if (position < 0) {
            view.setPivotX(view.getWidth());

        } else{
            view.setPivotX(0);
        }
        view.setPivotY(view.getHeight() *(int) deltaY);
        view.setRotationY(45 * position);*/

        if(position>lastPosition){
           /* ScaleAnimation anim=new ScaleAnimation(0.0f,1.0f,0.0f,1.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            anim.setDuration(new Random().nextInt(501));
            view.startAnimation(anim);*/
            Animation animation3= AnimationUtils.loadAnimation(mcontext,R.anim.fade);
            view.startAnimation(animation3);
            lastPosition=position;

        }
       // ObjectAnimator animation = ObjectAnimator.ofFloat(view, "rotationY", 0.0f, 90f);  // HERE 360 IS THE ANGLE OF ROTATE, YOU CAN USE 90, 180 IN PLACE OF IT,  ACCORDING TO YOURS REQUIREMENT

        //animation.setDuration(500); // HERE 500 IS THE DURATION OF THE ANIMATION, YOU CAN INCREASE OR DECREASE ACCORDING TO YOURS REQUIREMENT
      //  animation.setInterpolator(new AccelerateDecelerateInterpolator());
        //animation.start();
       /* Animation animation = AnimationUtils.loadAnimation(mcontext,
                (position > lastPosition) ? R.anim.bounce
                        : R.anim.fade);
        view.startAnimation(animation);
        lastPosition = position;*/
    }
/*

    @Override
    public void onViewDetachedFromWindow(@NonNull ColorViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
       */
/* Animation animation3= AnimationUtils.loadAnimation(mcontext,R.anim.slide_in_right);
        holder.itemView.startAnimation(animation3);*//*

        ScaleAnimation anim=new ScaleAnimation(0.0f,1.0f,0.0f,1.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        anim.setDuration(new Random().nextInt(501));
        holder.itemView.clearAnimation();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
*/
  /*  @Override
    public void onViewDetachedFromWindow(@NonNull ColorViewHolder holder) {
         super.onViewDetachedFromWindow(holder);

    *//*  Animation animation3= AnimationUtils.loadAnimation(mcontext,R.anim.slide_in_right);
        holder.itemView.startAnimation(animation3);*//**//*

        ScaleAnimation anim=new ScaleAnimation(0.0f,1.0f,0.0f,1.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        anim.setDuration(new Random().nextInt(501));*//*
        holder.itemView.clearAnimation();
    }*/
    @Override
    public int getItemCount() {
        return marraylist.size();
    }

    public static class ColorViewHolder extends RecyclerView.ViewHolder{

        TextView color;
        RelativeLayout layout;
        public ColorViewHolder(@NonNull View itemView, final onclicklistener listener) {
            super(itemView);

            color=itemView.findViewById(R.id.color);
            layout=itemView.findViewById(R.id.layout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    if(listener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.oncityselelected(position);
                        }
                    }

                }
            });

        }
    }
}
