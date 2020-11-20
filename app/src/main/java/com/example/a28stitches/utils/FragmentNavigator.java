package com.example.a28stitches.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.a28stitches.ui.FirstStartFragment;
import com.example.a28stitches.ui.KnitPatternsFragment;

// Launch actual fragments
public class FragmentNavigator {
    private Context mContext;
    private FragmentManager mFragmentManager;
    private int mContainer;

    public FragmentNavigator(Context context, FragmentManager fragmentManager, int container) {
        this.mContext = context;
        mFragmentManager = fragmentManager;
        mContainer = container;
    }

    // Launch fragment for chosen role
    // Need to show available features for every role and hide special for the curator data
    //TODO Add authentication
    public void launchFragment(int roleID) {
        Fragment fragment = getFragmentByRole(roleID);
        mFragmentManager
                .beginTransaction()
                .replace(mContainer, fragment, fragment.getClass().getCanonicalName())
                .addToBackStack(fragment.getClass().getCanonicalName())
                .commit();
    }

    private Fragment getFragmentByRole(int roleID) {
        switch (roleID) {
            case Constants.ROLE_VOLUNTEER:
                return new KnitPatternsFragment();
            case Constants.ROLE_CURATOR:
                //TODO:
                break;
            case Constants.ROLE_DOCTOR:
                //TODO:
                break;
            default:
                //Launch FirstStartFragment for choosing user role only for the first start app
                return new FirstStartFragment();
        }
        return null;
    }
}
