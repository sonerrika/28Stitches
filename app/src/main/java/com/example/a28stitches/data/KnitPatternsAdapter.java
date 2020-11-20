package com.example.a28stitches.data;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a28stitches.R;

import java.util.ArrayList;

public class KnitPatternsAdapter extends
        RecyclerView.Adapter<KnitPatternsAdapter.KnitPatternsViewHolder> {

    private ArrayList<KnitPatterns> mPatternsList = new ArrayList<>();

    public KnitPatternsAdapter(ArrayList<KnitPatterns> patternsList) {
        this.mPatternsList = patternsList;
    }

    @NonNull
    @Override
    public KnitPatternsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.pattern_view, viewGroup, false);
        return new KnitPatternsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KnitPatternsViewHolder knitPatternsViewHolder, int position) {
        knitPatternsViewHolder.bind(mPatternsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPatternsList.size();
    }

    class KnitPatternsViewHolder extends RecyclerView.ViewHolder {

        private ImageView mPatternSchemaView;
        private ImageView mPatternPhotoView;
        private TextView mPatternNameView;

        public KnitPatternsViewHolder(View itemView) {
            super(itemView);
            mPatternSchemaView = itemView.findViewById(R.id.pattern_scheme);
            mPatternPhotoView = itemView.findViewById(R.id.pattern_photo);
            mPatternNameView = itemView.findViewById(R.id.pattern_name);
        }

        public void bind(KnitPatterns knitPattern) {
            mPatternSchemaView.setImageDrawable(knitPattern.getPatternSchema());
            mPatternPhotoView.setImageDrawable(knitPattern.getPatternPhoto());
            mPatternNameView.setText(knitPattern.getPatternName());
        }
    }


}
