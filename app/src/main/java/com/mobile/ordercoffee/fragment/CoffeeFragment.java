package com.mobile.ordercoffee.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.ArrayList;
import java.util.List;

public class CoffeeFragment extends Fragment {

    TextView tvHot, tvCold, tvCake;

    private List<Product> list = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_coffee, container, false);

        final TopActivity activity = (TopActivity) getActivity(); //

        tvCold = rootView.findViewById(R.id.cf_tvCold);
        tvHot = rootView.findViewById(R.id.cf_tvHot);
        tvCake = rootView.findViewById(R.id.cf_tvCake);

        list.clear();
        for(Product item : activity.listData){
            if(item.getType().equals("hot")){
                list.add(item);
            }
        }

        final ProductAdapter adapter = new ProductAdapter(activity, list, false);
        adapter.setListener(new ProductAdapter.ProductAdapterListener() {
            @Override
            public void onItemRemove(int position, Product item) {

            }

            @Override
            public void onItemClicked(int position, Product item) {
                activity.listSelected.add(item);
                Toast.makeText(activity, "Added", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView rvProduct = rootView.findViewById(R.id.cf_rycViewProduct);
        LinearLayoutManager llm = new LinearLayoutManager(activity);
        llm.setOrientation(RecyclerView.VERTICAL);
        rvProduct.setLayoutManager(llm);

        rvProduct.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        tvCold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                for(Product item : activity.listData){
                    if(item.getType().equals("sneaker")){
                        list.add(item);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
        tvHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                for(Product item : activity.listData){
                    if(item.getType().equals("hot")){
                        list.add(item);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
        tvCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                for(Product item : activity.listData){
                    if(item.getType().equals("boot")){
                        list.add(item);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
        return  rootView;
    }


}
