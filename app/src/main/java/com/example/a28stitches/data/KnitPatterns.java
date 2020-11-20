package com.example.a28stitches.data;

import android.graphics.drawable.Drawable;

public class KnitPatterns {
    private Drawable mPatternSchema;
    private Drawable mPatternPhoto;
    private String mPatternName;

    public KnitPatterns(String patternName, Drawable patternSchema, Drawable patternPhoto) {
        this.mPatternName = patternName;
        this.mPatternSchema = patternSchema;
        this.mPatternPhoto = patternPhoto;
    }

    public Drawable getPatternSchema() {
        return mPatternSchema;
    }

    public Drawable getPatternPhoto() {
        return mPatternPhoto;
    }

    public String getPatternName() {
        return mPatternName;
    }
}
