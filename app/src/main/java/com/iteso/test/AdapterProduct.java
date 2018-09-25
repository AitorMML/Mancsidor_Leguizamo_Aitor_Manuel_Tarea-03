package com.iteso.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iteso.test.Beans.ItemProduct;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {

    private ArrayList<ItemProduct> products;
    private Context context; //auxiliar

    public AdapterProduct(Context context, ArrayList<ItemProduct> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title;

        public ViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.item_product_image);
            title = v.findViewById(R.id.item_product_title);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(products.get(position).getTitle());
        switch (products.get(position).getImage() ) {
            case 0:
                holder.image.setImageResource(R.drawable.mac);
                break;
            case 1:
                holder.image.setImageResource(R.drawable.alienware);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}

