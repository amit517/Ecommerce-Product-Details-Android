package com.team.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.team.myapplication.GiveMeProduct;
import com.team.myapplication.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Amit on 25,November,2020
 */
public class ProductAdpater extends RecyclerView.Adapter<ProductAdpater.ViewHolder> {

    private Context context;
    private final ItemClickListener listener;
    private int row_index = -1;
    public ProductAdpater(Context context, ItemClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public interface ItemClickListener {
        void position(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.productImage.setImageResource(GiveMeProduct.getProduct().get(position).getMainImage());
        holder.productImage.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_image));
        /*if(row_index==position){
            holder.productImage.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_image));
        }
        else
        {
            holder.productImage.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_image));
        }*/

    }

    @Override
    public int getItemCount() {
        return GiveMeProduct.getProduct().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private WeakReference<ItemClickListener> listenerRef;
        private ImageView productImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listenerRef = new WeakReference<>(listener); // Click Listener Ref
            productImage = itemView.findViewById(R.id.productImage);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == productImage.getId()){
               //row_index = getAdapterPosition();
                listenerRef.get().position(getAdapterPosition());
                notifyDataSetChanged();
            }
        }
    }
}
