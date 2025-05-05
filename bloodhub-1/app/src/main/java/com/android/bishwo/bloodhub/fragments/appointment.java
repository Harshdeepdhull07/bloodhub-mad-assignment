package com.android.bishwo.bloodhub.fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.android.bishwo.bloodhub.R;
import java.util.Calendar;

public class appointment extends Fragment {

    EditText editTextName;
    Button buttonBook, buttonDate, buttonTime;
    TextView textViewSelectedDate, textViewSelectedTime;
    Calendar calendar;
    int year, month, day, hour, minute;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.appointment, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        buttonBook = view.findViewById(R.id.buttonBook);
        buttonDate = view.findViewById(R.id.buttonDate);
        buttonTime = view.findViewById(R.id.buttonTime);
        textViewSelectedDate = view.findViewById(R.id.textViewSelectedDate);
        textViewSelectedTime = view.findViewById(R.id.textViewSelectedTime);

        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment();
            }
        });

        return view;
    }

    private void showDatePickerDialog() {
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                textViewSelectedDate.setText(selectedDate);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String selectedTime = hourOfDay + ":" + minute;
                textViewSelectedTime.setText(selectedTime);
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

    private void bookAppointment() {
        String name = editTextName.getText().toString().trim();
        String selectedDate = textViewSelectedDate.getText().toString().trim();
        String selectedTime = textViewSelectedTime.getText().toString().trim();

        // Validate input
        if (name.isEmpty() || selectedDate.isEmpty() || selectedTime.isEmpty()) {
            Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Call method to book appointment (this is where you'd integrate backend logic)
        // For simplicity, let's just show a toast message here
        Toast.makeText(getContext(), "Appointment booked for " + name + " on " + selectedDate + " at " + selectedTime, Toast.LENGTH_SHORT).show();
    }
}
