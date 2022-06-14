package com.example.meetandmeet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meetandmeet.databinding.FragmentDetailsBinding;
import com.google.android.gms.common.annotation.NonNullApi;
import com.example.meetandmeet.databinding.FragmentDetailsBinding;

public class DetailsFragment extends Fragment {
    private FragmentDetailsBinding binding;

    public DetailsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModel.getSelected().observe(getViewLifecycleOwner(), item -> {
            binding.nameTv.setText(item.getName());
            binding.birthdayTV.setText(item.getBirthday());
            binding.phoneTv.setText(item.getPhone());
            binding.flowerpotIv.setImageResource(item.getImage());
            binding.progressBar.setProgress(item.getPrograssBar());
        });
    }
}