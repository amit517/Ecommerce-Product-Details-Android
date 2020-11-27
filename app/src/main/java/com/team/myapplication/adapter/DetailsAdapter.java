package com.team.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.team.myapplication.R;
import com.team.myapplication.utils.CurrentProduct;

import java.lang.ref.WeakReference;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {

    private Context context;
    private final DescriptionClickListener listener;
    private int row_index = -1;

    public DetailsAdapter(Context context, DescriptionClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public interface DescriptionClickListener {
        void position(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_image_2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.productImage.setImageResource(CurrentProduct.getCurrentProduct().getExampleArrayList().get(position).getFrontImg());
        if(row_index==position){
            holder.productImage.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_green_image));
        }
        else
        {
            holder.productImage.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_round_corner_2));
        }
        holder.productImage.setClipToOutline(true);

    }

    @Override
    public int getItemCount() {
        return CurrentProduct.getCurrentProduct().getExampleArrayList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private WeakReference<DescriptionClickListener> listenerRef;
        private ImageView productImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listenerRef = new WeakReference<>(listener); // Click Listener Ref
            productImage = itemView.findViewById(R.id.productImage);
            productImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == productImage.getId()){
                row_index = getAdapterPosition();
                listenerRef.get().position(getAdapterPosition());
                notifyDataSetChanged();
            }
        }
    }
}
