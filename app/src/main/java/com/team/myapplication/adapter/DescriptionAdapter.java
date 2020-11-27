package com.team.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team.myapplication.utils.Constant;
import com.team.myapplication.R;

/**
 * Created by Amit on 26,November,2020
 */
public class DescriptionAdapter extends RecyclerView.Adapter<DescriptionAdapter.ViewHolder> {
    private Context context;


    public DescriptionAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_specification, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.drawer_icon.setImageResource(Constant.getDraware().get(position).getImgResID());
        holder.drawer_itemName.setText(Constant.getDraware().get(position).getItemName());
    }

    @Override
    public int getItemCount() {
        return Constant.getDraware().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView drawer_icon;
        private TextView drawer_itemName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            drawer_icon = itemView.findViewById(R.id.drawer_icon);
            drawer_itemName = itemView.findViewById(R.id.drawer_itemName);
        }

        }
    }
