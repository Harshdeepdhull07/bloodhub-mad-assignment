package com.android.bishwo.bloodhub.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.bishwo.bloodhub.R;

public class doctor extends Fragment {
    private TextView textView;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.doctor,container, false);
        getActivity().setTitle("Doctors List");

        textView = view.findViewById(R.id.addressTextView);
        Linkify.addLinks(textView, Linkify.ALL);
        return  view;
    }
}
