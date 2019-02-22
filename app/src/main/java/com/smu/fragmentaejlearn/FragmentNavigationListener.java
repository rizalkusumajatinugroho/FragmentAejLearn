package com.smu.fragmentaejlearn;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by sapuser on 2/10/2019.
 */

public interface FragmentNavigationListener {
    void openFragmentSatuListener(Bundle bundle);
    void openFragmentDuaListener(Bundle bundle);

    void openFragment(Fragment fragment);
}
