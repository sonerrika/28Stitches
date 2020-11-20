package com.example.a28stitches;

import android.content.Context;

import com.example.a28stitches.presenters.KnitPatternsPresenter;
import com.example.a28stitches.ui.KnitPatterns;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.ArrayList;

import static org.junit.Assert.assertNotEquals;

@RunWith(RobolectricTestRunner.class)
public class KnitPatternPresenterTest {
    
    private Context mContext;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mContext = RuntimeEnvironment.application;
    }

    @Test
    public void testDefaultCreate() {
        KnitPatternsPresenter presenter = new KnitPatternsPresenter(mContext);
        assertNotEquals(null, presenter);
    }

    @Test
    public void testInitData() {
        KnitPatternsPresenter presenter = new KnitPatternsPresenter(mContext);
        ArrayList<KnitPatterns> list = presenter.initData(mContext);
        assertNotEquals(true, list.isEmpty());
    }
}
