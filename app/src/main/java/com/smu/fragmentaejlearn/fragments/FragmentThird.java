package com.smu.fragmentaejlearn.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smu.fragmentaejlearn.R;
import com.smu.fragmentaejlearn.childFragments.FragmentFive;
import com.smu.fragmentaejlearn.childFragments.FragmentFour;

public class FragmentThird extends Fragment {

    public FragmentThird() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_third, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentFour fragmentFour = new FragmentFour();
        FragmentFive fragmentFive = new FragmentFive();

        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.containerTop, fragmentFour)
                .replace(R.id.containerBottom, fragmentFive)
                .commit();


    }
}
