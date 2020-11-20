package com.example.a28stitches.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.a28stitches.MainActivity;
import com.example.a28stitches.utils.Constants;
import com.example.a28stitches.R;

import static android.content.Context.MODE_PRIVATE;

public class FirstStartFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_start_layout, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button startButton = view.findViewById(R.id.start_button);
        final RadioGroup roleRadioGroup = view.findViewById(R.id.user_role);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioButtonID = roleRadioGroup.getCheckedRadioButtonId();
                ((MainActivity) getActivity()).getFragmentNavigator().launchFragment(
                        getRoleID(radioButtonID));
                saveRole(radioButtonID);
                ((MainActivity) getActivity()).setHeaderGroupVisibility(true);
            }
        });
    }

    private void saveRole(int roleID) {
        SharedPreferences appPreferences = getActivity().getSharedPreferences(
                Constants.APP_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = appPreferences.edit();
        editor.putInt(Constants.APP_PREFERENCES_ROLE, getRoleID(roleID));
        editor.apply();
    }

    private int getRoleID(int radioButtonID) {
        switch (radioButtonID) {
            case R.id.volunteer:
                return Constants.ROLE_VOLUNTEER;
            case R.id.curator:
                return Constants.ROLE_CURATOR;
            case R.id.doctor:
                return Constants.ROLE_UNDEFINE;
        }
        return Constants.ROLE_UNDEFINE;
    }

    @VisibleForTesting
    public void setSharedPreferences(String roleID, int value ) {
        SharedPreferences appPreferences = getActivity().getSharedPreferences(
                Constants.APP_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = appPreferences.edit();
        editor.putInt(roleID, getRoleID(value));
        editor.apply();
    }
}
