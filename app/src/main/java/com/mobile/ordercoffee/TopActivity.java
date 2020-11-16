package com.mobile.ordercoffee;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mobile.ordercoffee.adapter.ProductAdapter;
import com.mobile.ordercoffee.adapter.TopAdapter;
import com.mobile.ordercoffee.db.Product;

import java.util.ArrayList;
import java.util.List;

public class TopActivity extends AppCompatActivity {

    private ViewPager viewPager;

    //Dữ liệu xài ở nhiều activity
    //Function và variable được sử dụng ở nhiều fragment
    //Event, function, liên kết các fragment

    public List<Product> listData = new ArrayList<>();
    public List<Product> listSelected = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        initData();

        viewPager = findViewById(R.id.view_pager);
        final TopAdapter topAdaptere = new TopAdapter(getSupportFragmentManager());
        viewPager.setAdapter(topAdaptere);

        BottomNavigationView navigation = findViewById(R.id.home_navView);
        //Maximum number of items supported by BottomNavigationView is 5
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        viewPager.setCurrentItem(0);
                        break;
//                    case R.id.nav_add_product:
//                        viewPager.setCurrentItem(1);
//                        break;
                    case R.id.nav_product:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.nav_cart:
                        viewPager.setCurrentItem(3);
                        topAdaptere.cartFragment.resume();
                        break;
                    case R.id.nav_history:
                        viewPager.setCurrentItem(4);
                        break;
                    case R.id.nav_account:
                        viewPager.setCurrentItem(5);
                        break;
                }
                return true;
            }
        });




    }
    public void initData(){
        listData.add(new Product(1, "S11014", "350000", "sneaker", R.drawable.sneaker_11014));
        listData.add(new Product(2, "S11001", "350000", "sneaker", R.drawable.sneaker_11001));
        listData.add(new Product(3, "S10993", "350000", "sneaker", R.drawable.sneaker_10993));
        listData.add(new Product(4, "S10978", "350000", "sneaker", R.drawable.sneaker_10978));
        listData.add(new Product(5, "S10948", "350000", "sneaker", R.drawable.sneaker_10948));
        listData.add(new Product(6, "S10894", "400000", "hot", R.drawable.hot_10894));
        listData.add(new Product(7, "S10856", "350000", "hot", R.drawable.hot_10856));
        listData.add(new Product(8, "S10812", "400000", "hot", R.drawable.hot_10812));
        listData.add(new Product(9, "S10805", "400000", "hot", R.drawable.hot_10805));
        listData.add(new Product(10, "S10230", "350000", "hot", R.drawable.hot_10230));
        listData.add(new Product(11, "B11048", "350000", "boot", R.drawable.boot_11048));
        listData.add(new Product(12, "B11005", "350000", "boot", R.drawable.boot_11005));
        listData.add(new Product(13, "B10997", "350000", "boot", R.drawable.boot_10997));
        listData.add(new Product(14, "B10983", "350000", "boot", R.drawable.boot_10983));
        listData.add(new Product(15, "B10976", "350000", "boot", R.drawable.boot_10976));
    }
}
