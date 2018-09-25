package com.iteso.test;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.test.Beans.ItemProduct;

import org.w3c.dom.Text;

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
        private Button detail;
        private ImageView image;
        private ImageView thumbnail;
        private TextView title;
        private TextView store;
        private TextView location;
        private TextView phone;
        private RelativeLayout eventLayout;


        public ViewHolder(View v) {
            super(v);
            eventLayout = (RelativeLayout) v.findViewById(R.id.item_product_layout);
            detail = (Button) v.findViewById(R.id.item_product_detail);
            image = (ImageView) v.findViewById(R.id.item_product_image);
            thumbnail = (ImageView) v.findViewById(R.id.item_product_thumbnail);
            title = (TextView) v.findViewById(R.id.item_product_title);
            store = (TextView) v.findViewById(R.id.item_product_store);
            location = (TextView) v.findViewById(R.id.item_product_location);
            phone = (TextView) v.findViewById(R.id.item_product_phone);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(products.get(position).getTitle());
        holder.store.setText(products.get(position).getStore());
        holder.location.setText(products.get(position).getLocation());
        holder.phone.setText(products.get(position).getPhone());

        switch (products.get(position).getImage() ) {
            case 0:
                holder.image.setImageResource(R.drawable.mac);
                break;
            case 1:
                holder.image.setImageResource(R.drawable.alienware);
                break;
        }
        Bitmap bitmap = ((BitmapDrawable) holder.thumbnail.getDrawable()).getBitmap();
        //holder.thumbnail.setImageBitmap(RoundedBitmapDrawable );


        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, products.get(position).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + products.get(position).getPhone()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }



}

