package com.example.a28stitches;

import android.content.SharedPreferences;
import android.support.constraint.Group;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.a28stitches.utils.Constants;
import com.example.a28stitches.utils.FragmentNavigator;


public class MainActivity extends AppCompatActivity {

    private FragmentNavigator mFragmentNavigator;
    private Group mHeaderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentNavigator = new FragmentNavigator(this, getSupportFragmentManager(),
                R.id.fragment_container);

        ImageView menuButton = findViewById(R.id.menu_button);
        mHeaderGroup = findViewById(R.id.header_group);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Show/hide drawer. Content has to be changed according to the chosen role

            }
        });

        SharedPreferences appPreferences = getSharedPreferences(Constants.APP_PREFERENCES,
                MODE_PRIVATE);
        int role = appPreferences.getInt(Constants.APP_PREFERENCES_ROLE, 0);
        mHeaderGroup.setVisibility(role == Constants.ROLE_UNDEFINE ? View.GONE : View.VISIBLE);
        mFragmentNavigator.launchFragment(role);
    }

    public FragmentNavigator getFragmentNavigator() {
        return mFragmentNavigator;
    }

    public void setHeaderGroupVisibility(boolean isVisible) {
        mHeaderGroup.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }
}
