package com.example.meetandmeet;
/// 코드 작성자 2020039085 서민정 ///
import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CalendarFragment extends Fragment {
    private static final String DATE_TEMPLATE = "dd/MM/yyyy";
    private static final String MONTH_TEMPLATE = "yyyy mmmm";
    private TextView textView;
    public io.blackbox_vision.materialcalendarview.view.CalendarView calendarView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calendar,container,false);

        calendarView = (io.blackbox_vision.materialcalendarview.view.CalendarView) rootView.findViewById(R.id.calendar_view);
        textView=(TextView)rootView.findViewById(R.id.textview);

        calendarView.shouldAnimateOnEnter(true)
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setOnDateClickListener(this::onDateClick)
                .setOnMonthChangeListener(this::onMonthChange)
                .setOnDateLongClickListener(this::onDateLongClick)
                .setOnMonthTitleClickListener(this::onMonthTitleClick);

        if (calendarView.isMultiSelectDayEnabled()) {
            calendarView.setOnMultipleDaySelectedListener(this::onMultipleDaySelected);
        }
        calendarView.update(Calendar.getInstance(Locale.getDefault()));
        textView.setText(String.format("Today is %s", formatDate(DATE_TEMPLATE, new Date(System.currentTimeMillis()))));
        Log.e("Frag","CalendarFragment");
        return rootView;

    }

    private void onMultipleDaySelected(int i, List<Date> dates) {
    }

    private void onMonthTitleClick(Date date) {
    }

    private void onDateLongClick(Date date) {
        textView.setText(formatDate(DATE_TEMPLATE, date));
    }

    private void onMonthChange(Date date) {

    }
    private String formatDate(@NonNull String dateTemplate, @NonNull Date date) {
        return new SimpleDateFormat(dateTemplate, Locale.getDefault()).format(date);
    }
    private void onDateClick(Date date) {
        textView.setText(formatDate(DATE_TEMPLATE, date));
    }

    public void prepareTextView() {
        textView.setText(String.format("Today is %s", formatDate(DATE_TEMPLATE, new Date(System.currentTimeMillis()))));
    }
}
