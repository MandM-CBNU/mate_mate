package com.example.meetandmeet.ui.flower_info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.meetandmeet.databinding.FragmentFlowerInfoBinding;

public class Flower_InfoFragment extends Fragment {

private FragmentFlowerInfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        Flower_InfoViewModel notificationsViewModel =
                new ViewModelProvider(this).get(Flower_InfoViewModel.class);

    binding = FragmentFlowerInfoBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}