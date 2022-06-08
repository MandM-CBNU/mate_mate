package com.example.meetandmeet;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

public class CalendarFragment extends Fragment {
    @Nullable
    private ProgressBar prg;
    private Button decrease;
    private Button increase;
    private int int_ventilator;
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calendar,container,false);
        prg = (ProgressBar) rootView.findViewById(R.id.progressBar);
        decrease = (Button) rootView.findViewById(R.id.decrease);
        increase = (Button) rootView.findViewById(R.id.increase);
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(int_ventilator > 0){
                    int_ventilator=int_ventilator-5;
                }
                prg.setProgress(int_ventilator);
                prg.getProgressDrawable().setColorFilter(
                        Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
            }
        });
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(int_ventilator <100) {
                    int_ventilator = int_ventilator + 5;
                }
                prg.setProgress(int_ventilator);
                prg.getProgressDrawable().setColorFilter(
                        Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
            }
        });
        Log.e("Frag","CalendarFragment");
        return rootView;
    }
}
