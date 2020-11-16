package com.mobile.ordercoffee.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.mobile.ordercoffee.fragment.AccountFragment;
import com.mobile.ordercoffee.fragment.CartFragment;
import com.mobile.ordercoffee.fragment.CoffeeFragment;
import com.mobile.ordercoffee.fragment.HistoryFragment;
import com.mobile.ordercoffee.fragment.HomeFragment;

public class TopAdapter extends FragmentStatePagerAdapter {

    public CartFragment cartFragment = new CartFragment();

    public TopAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public TopAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
//            case 1:
//                return new AddProductFragment();
            case 2:
                return new CoffeeFragment();
            case 3:
                return cartFragment;
            case 4:
                return new HistoryFragment();
            case 5:
                return new AccountFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 6;
    }
}
