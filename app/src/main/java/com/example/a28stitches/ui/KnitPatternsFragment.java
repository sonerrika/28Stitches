package com.example.a28stitches.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a28stitches.R;
import com.example.a28stitches.presenters.KnitPatternsPresenter;

public class KnitPatternsFragment extends Fragment implements KnitPatternInterface {

    private KnitPatternsAdapter mAdapter;
    private KnitPatternsPresenter mKnitPatternsPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.knit_patterns_fragment, null);

        mKnitPatternsPresenter = new KnitPatternsPresenter(getContext());
        mKnitPatternsPresenter.setKnitPatternsInterface(this);
        mAdapter = new KnitPatternsAdapter(mKnitPatternsPresenter.initData(getContext()));
        initRecyclerView(view);
        //TODO Implement a FAB for adding a new pattern
        //mKnitPatternsPresenter.addNewPattern();
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.patterns_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void updateData() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        mKnitPatternsPresenter.removeKnitPatternsInterface();
        mKnitPatternsPresenter = null;
        super.onDestroy();
    }
}
