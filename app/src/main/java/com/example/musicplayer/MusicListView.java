package com.example.musicplayer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicListView extends RecyclerView.Adapter<MusicListView.ViewHolder> {

    ArrayList<String> arrayList;
    ItemClickListener itemClickListener;

    int selectedPosition = -1;

    public MusicListView(ArrayList<String> arrayList, ItemClickListener itemClickListener) {
        this.arrayList = arrayList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listcard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(arrayList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();

                itemClickListener.onClick(position, arrayList.get(position), v);

                selectedPosition = position;

                notifyDataSetChanged();
            }
        });

        if (selectedPosition == position){
            holder.cardView.setCardBackgroundColor(Color.parseColor("#6363E2"));
            holder.textView.setTextColor(Color.parseColor("#ffffff"));
        } else {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#ffffff"));
            holder.textView.setTextColor(Color.parseColor("#000000"));
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder {

        CardView cardView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            textView = itemView.findViewById(R.id.songName);
        }
    }
}
