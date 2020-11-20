package com.example.a28stitches;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.a28stitches.ui.FirstStartFragment;
import com.example.a28stitches.utils.Constants;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static android.content.Context.MODE_PRIVATE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class FirstStartFragmentTest {

    private Context mContext;
    private MainActivity mMainActivity;
    private FirstStartFragment mFragment;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mMainActivity = Robolectric.setupActivity(MainActivity.class);
        mFragment = new FirstStartFragment();
        startFragment(mFragment);
        mContext = RuntimeEnvironment.application;
    }

    @Test
    public void testDefaultCreate() {
        FirstStartFragment fragment = new FirstStartFragment();
        assertNotNull(fragment);
    }

    @Test
    public void testStartButton() {
        FirstStartFragment fragment = new FirstStartFragment();
        startFragment(fragment);

        Button button = fragment.getView().findViewById(R.id.start_button);
        RadioButton radioButton = fragment.getView().findViewById(R.id.volunteer);
        assertNotNull(button);
        assertNotNull(radioButton);

        radioButton.setChecked(true);
        button.performClick();
        SharedPreferences appPreferences = mContext.getSharedPreferences(Constants.APP_PREFERENCES,
                MODE_PRIVATE);
        int role = appPreferences.getInt(Constants.APP_PREFERENCES_ROLE, 0);
        assertEquals(1, role);
    }

    private void startFragment(Fragment fragment) {
        FragmentManager fm = mMainActivity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(fragment, null)
                .commit();
    }
}
