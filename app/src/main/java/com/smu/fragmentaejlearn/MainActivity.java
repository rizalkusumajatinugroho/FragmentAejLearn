package com.smu.fragmentaejlearn;

import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.smu.fragmentaejlearn.fragments.FragmentFirst;
import com.smu.fragmentaejlearn.fragments.FragmentSecond;

public class MainActivity extends AppCompatActivity implements FragmentNavigationListener{

    String activeFragment = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            activeFragment = savedInstanceState.getString("fragment");
            openCurrentFragment();
        }else{
            openFragmentSatu(new Bundle());
        }

    }

    private void openCurrentFragment() {
        if (activeFragment.equalsIgnoreCase("FragmentFirst")){
            openFragmentSatu(new Bundle());
        }else if (activeFragment.equalsIgnoreCase("FragmentSecond")){
            openFragmentDua(new Bundle());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString("fragment", activeFragment);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    public void openFragmentSatu(Bundle bundle) {
        FragmentFirst fragmentFirst = new FragmentFirst();
        activeFragment = fragmentFirst.getClass().getSimpleName();
        fragmentFirst.setFragmentNavigationListener(this);
        fragmentFirst.setArguments(bundle);
        commitFragment(fragmentFirst);
    }

    public void openFragmentDua(Bundle bundle) {
        FragmentSecond fragmentSecond = new FragmentSecond();
        activeFragment = fragmentSecond.getClass().getSimpleName();
        fragmentSecond.setFragmentNavigationListener(this);
        commitFragment(fragmentSecond);
    }

    private void commitFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack("flow");
        fragmentTransaction.commit();
    }


    @Override
    public void openFragmentSatuListener(Bundle bundle) {
        openFragmentSatu(bundle);
    }

    @Override
    public void openFragmentDuaListener(Bundle bundle) {
        openFragmentDua(bundle);
    }

    @Override
    public void openFragment(Fragment fragment) {
        commitFragment(fragment);
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
