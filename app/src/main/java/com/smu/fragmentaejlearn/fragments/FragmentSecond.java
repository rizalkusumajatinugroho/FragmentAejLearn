package com.smu.fragmentaejlearn.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.smu.fragmentaejlearn.FragmentNavigationListener;
import com.smu.fragmentaejlearn.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSecond extends Fragment implements View.OnClickListener{


    private String message;
    private FragmentNavigationListener fragmentNavigationListener;

    public FragmentSecond() {
        // Required empty public constructor
    }

    public void setFragmentNavigationListener(FragmentNavigationListener fragmentNavigationListener){
        this.fragmentNavigationListener = fragmentNavigationListener;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState != null){
            message = savedInstanceState.getString("retainedData");
        }

        return inflater.inflate(R.layout.fragment_fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvMessage = view.findViewById(R.id.tvFragmentSecond);
        Button btnGoToFragment3 = view.findViewById(R.id.btnGoToFragment3);
        btnGoToFragment3.setOnClickListener(this);
        createDataBundle();
        setMessage(tvMessage);

    }

    private void setMessage(TextView textView) {
        if (message != null && !message.isEmpty()){
            textView.setText(message);
        }
    }

    private void createDataBundle() {
        Bundle bundle = getArguments();
        if (bundle != null){
            message = message == null ? bundle.getString("data") : message;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGoToFragment3:
                goToThirdFragment();
                break;
            default:
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (message != null){
            outState.putString("retainedData", message);
        }
        super.onSaveInstanceState(outState);

    }

    private void goToThirdFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("data", "dikirm dari fragment Second");
        bundle.putString("data1", "JudulParam2");
        FragmentThird fragmentThird = new FragmentThird();
        fragmentThird.setArguments(bundle);
        fragmentNavigationListener.openFragment(fragmentThird);
    }
}
