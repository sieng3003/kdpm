package com.mobile.ordercoffee.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mobile.ordercoffee.LoginActivity;
import com.mobile.ordercoffee.R;
import com.mobile.ordercoffee.TopActivity;

public class AccountFragment extends Fragment {

    Button btnLogOut;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account, container,false);

        btnLogOut = rootView.findViewById(R.id.account_btnLogOut);

        final TopActivity activity = (TopActivity) getActivity();

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity, LoginActivity.class));
            }
        });

        return rootView;
    }
}
