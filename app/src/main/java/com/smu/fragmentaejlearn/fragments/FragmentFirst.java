package com.smu.fragmentaejlearn.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.smu.fragmentaejlearn.FragmentNavigationListener;
import com.smu.fragmentaejlearn.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFirst extends Fragment implements View.OnClickListener{


    private FragmentNavigationListener fragmentNavigationListener;

    public FragmentFirst() {
        // Required empty public constructor
    }

    public void setFragmentNavigationListener(FragmentNavigationListener fragmentNavigationListener){
        this.fragmentNavigationListener = fragmentNavigationListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.btnToNextFragment);
        button.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnToNextFragment :
                goToSecondFragment();
                break;
            default:
                break;
        }
    }

    private void goToSecondFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("data", "dikirm dari fragment First");
       fragmentNavigationListener.openFragmentDuaListener(bundle);
    }
}
