package com.mobile.ordercoffee.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mobile.ordercoffee.R;
import com.mobile.ordercoffee.db.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private List<Product> list;
    private ProductAdapterListener listener;
    private boolean isDelete;

    public ProductAdapter(Context context, List<Product> list, boolean isDelete) {
        this.context = context;
        this.list = list;
        this.isDelete = isDelete;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setListener(ProductAdapterListener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProduct;
        private TextView tvNameContent;
        private TextView tvPriceContent;
        private Button btnAdd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgProduct = itemView.findViewById(R.id.cus_imgProduct);
            this.tvNameContent = itemView.findViewById(R.id.cus_tvNameProduct);
            this.tvPriceContent = itemView.findViewById(R.id.cus_tvPriceProduct);
            this.btnAdd = itemView.findViewById(R.id.add);

            if(isDelete){
                btnAdd.setText("Delete");
            }
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        if(isDelete){
                            listener.onItemRemove(getAdapterPosition(), list.get(getAdapterPosition()));
                        }
                        else{
                            listener.onItemClicked(getAdapterPosition(), list.get(getAdapterPosition()));
                        }
                    }
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        listener.onItemClicked(getAdapterPosition(), list.get(getAdapterPosition()));
                    }
                }
            });


        }

        public void bind(Product product) {

            Log.d("ttt", product.getId() + "-" + product.getName() + "-" + product.getPrice());
            this.tvNameContent.setText(product.getName());
            this.tvPriceContent.setText(product.getPrice());
            this.imgProduct.setImageResource(product.getPathImg());
            //picasso, glide
//            Log.d("ttt", "path: " + product.getPathImg());

        }

    }

    public interface ProductAdapterListener {
        void onItemRemove(int position, Product item);
        void onItemClicked(int position, Product item);
    }
}

