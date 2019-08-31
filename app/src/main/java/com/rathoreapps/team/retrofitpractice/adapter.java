package com.rathoreapps.team.retrofitpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<ViewHolder> {
    public adapter(@NonNull List<modelClass> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    private List<modelClass> dataList;

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(dataList.get(position).getId());
        holder.title.setText(dataList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder{
    TextView id, title;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        id = itemView.findViewById(R.id.id);
        title = itemView.findViewById(R.id.title);
    }
}
