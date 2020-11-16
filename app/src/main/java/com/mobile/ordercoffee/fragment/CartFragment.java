package com.mobile.ordercoffee.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.ordercoffee.R;
import com.mobile.ordercoffee.TopActivity;
import com.mobile.ordercoffee.adapter.ProductAdapter;
import com.mobile.ordercoffee.db.Product;

public class CartFragment extends Fragment {

    ProductAdapter adapter;
    TopActivity activity;
//    TextView tvTotal;
    Button btnOrder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cart,container,false);

//        tvTotal = rootView.findViewById(R.id.cart_tvTotal);
        btnOrder = rootView.findViewById(R.id.cart_btnOrder);

        activity = (TopActivity) getActivity();

        RecyclerView rvProduct = rootView.findViewById(R.id.cart_rycViewCart);
        LinearLayoutManager llm = new LinearLayoutManager(activity);
        llm.setOrientation(RecyclerView.VERTICAL);
        rvProduct.setLayoutManager(llm);

        adapter = new ProductAdapter(activity, activity.listSelected, true);
        adapter.setListener(new ProductAdapter.ProductAdapterListener() {
            @Override
            public void onItemRemove(int position, Product item) {
                activity.listSelected.remove(position);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onItemClicked(int position, Product item) {

            }
        });

        rvProduct.setAdapter(adapter);

//        tvTotal.setText("Total: " + totalPrice());

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Ordered",Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;

    }

    public void resume(){
        Log.d("ttt", activity.listSelected.size() + "");
        if(adapter != null){
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        if(adapter != null){
            adapter.notifyDataSetChanged();
        }
        super.onResume();

    }

//    public int totalPrice()
//    {
//        int total = 0;
//        for (Product product : activity.listSelected){
//            total += Integer.parseInt(product.getPrice());
//        }
//        return total;
//    }
}
