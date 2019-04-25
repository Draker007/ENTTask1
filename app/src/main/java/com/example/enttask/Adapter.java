package com.example.enttask;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewholder> {

private List<data> dataList;

    public Adapter(List<data> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler,viewGroup,false);
        MyViewholder viewholder = new MyViewholder(v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder myViewholder, int i) {
    data data = dataList.get(i);
        myViewholder.contact.setText(data.getContact());
        myViewholder.name.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {
        TextView contact;
        TextView name;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            contact = itemView.findViewById(R.id.Contact);
            name = itemView.findViewById(R.id.name);


        }
    }
}
