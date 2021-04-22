package com.example.checkbox_arraylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuantityAdapter extends RecyclerView.Adapter<QuantityAdapter.MyViewHolder> {

    Context context;
    ArrayList<String> arrayList;
    QualatyListner qualatyListner;
    ArrayList<String> arrayList_0= new ArrayList<>();

    public QuantityAdapter(Context context, ArrayList<String> arrayList, QualatyListner qualatyListner) {
        this.context = context;
        this.arrayList = arrayList;
        this.qualatyListner = qualatyListner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (arrayList !=null && arrayList.size()>0){
            holder.checkBox.setText(arrayList.get(position));
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.checkBox.isChecked()){
                        arrayList_0.add(arrayList.get(position));
                    }else {
                        arrayList_0.remove(arrayList.get(position));
                    }
                    qualatyListner.onQualtityChange(arrayList_0);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox= itemView.findViewById(R.id.checkbox);
        }
    }
}
