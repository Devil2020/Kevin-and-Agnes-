package com.example.uianduxcourse.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uianduxcourse.R;

import java.util.ArrayList;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {

    private  Context context;
    private ArrayList<Integer> colors;

    public ColorAdapter(Context context, ArrayList<Integer> colors){
        this.colors=colors;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.color_card, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.colorCard.setCardBackgroundColor(colors.get(i));
        viewHolder.colorCard.setBackgroundColor(colors.get(i));
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView colorCard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            colorCard=itemView.findViewById(R.id.CardColor);
        }
    }
}
