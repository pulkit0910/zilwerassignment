package com.example.zilwerassignment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.imageviewholder> {


    public ArrayList<cardata> arrayList;
    public Context context;
    public adapter(ArrayList<cardata> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public imageviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.cardata,viewGroup,false);
        return new imageviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull imageviewholder imageviewholder, final int i) {

        Glide.with(context).load(arrayList.get(i).getImage()).into(imageviewholder.iv1);
        imageviewholder.tv1.setText(arrayList.get(i).getData());
        imageviewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), details.class);
                intent.putExtra("id",i);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class imageviewholder extends RecyclerView.ViewHolder

    {
        ImageView iv1;
        TextView tv1;

        public imageviewholder(View itemview){

            super(itemview);
            iv1 = (ImageView) itemview.findViewById(R.id.img);
            tv1 = itemview.findViewById(R.id.txt);

        }
    }
}

