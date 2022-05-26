package com.example.meetandmeet.ui.home;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.meetandmeet.R;
import com.example.meetandmeet.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
        ViewGroup container, Bundle savedInstanceState) {
            HomeViewModel dashboardViewModel =
                    new ViewModelProvider(this).get(HomeViewModel.class);

            binding = FragmentHomeBinding.inflate(inflater, container, false);
            View root = binding.getRoot();

            // final TextView textView = binding.textDashboard;
            //dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

            return root;
    }

    private static void onChangeFragment(int i) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}