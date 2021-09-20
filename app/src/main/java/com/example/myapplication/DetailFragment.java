package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.DefailFragmentBinding;

public class DetailFragment extends Fragment {

    DefailFragmentBinding binding;

    public static DetailFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
       // View view = inflater.inflate(R.layout.defail_fragment,container,false);

        binding = DataBindingUtil.inflate(inflater,R.layout.defail_fragment,container,false);


        binding.tvDetailFragment.setText("ABC");
        binding.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return binding.getRoot();
    }
}
