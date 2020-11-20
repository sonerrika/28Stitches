package com.example.a28stitches.presenters;

import android.content.Context;

import com.example.a28stitches.R;
import com.example.a28stitches.data.KnitPatterns;

import java.util.ArrayList;

public class KnitPatternsPresenter {

    private Context mContext;
    private KnitPatternInterface mKnitPatternInt;
    private ArrayList<KnitPatterns> mPatternList;

    public KnitPatternsPresenter(Context context) {
        mContext = context;
    }

    public void setKnitPatternsInterface(KnitPatternInterface knitPatternInt) {
        mKnitPatternInt = knitPatternInt;
    }

    public void removeKnitPatternsInterface() {
        mKnitPatternInt = null;
    }

    public ArrayList<KnitPatterns> initData(Context context) {
        //TODO Change ArrayList to DataBase
        mPatternList = new ArrayList<>();
        mPatternList.add(new KnitPatterns(mContext.getString(R.string.pattern_name_ajuo),
                mContext.getResources().getDrawable(R.drawable.ajuo_schema),
                mContext.getResources().getDrawable(R.drawable.ajuo_photo)));
        mPatternList.add(new KnitPatterns(mContext.getString(R.string.pattern_name_easy),
                mContext.getResources().getDrawable(R.drawable.easy_schema),
                mContext.getResources().getDrawable(R.drawable.easy_photo)));
        mPatternList.add(new KnitPatterns(mContext.getString(R.string.pattern_name_rhombus),
                mContext.getResources().getDrawable(R.drawable.romb_schema),
                mContext.getResources().getDrawable(R.drawable.romb_photo)));
        return mPatternList;
    }

    public void addNewPattern() {
        //TODO Add a new pattern from user
        mKnitPatternInt.updateData();
    }

}
