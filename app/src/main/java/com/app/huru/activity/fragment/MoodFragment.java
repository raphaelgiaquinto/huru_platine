package com.app.huru.activity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.huru.R;
import com.app.huru.activity.ActivityGUI;
import com.app.huru.activity.recyclerview.MoodViewAdapter;
import com.app.huru.model.Mood;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment concernant les humeurs
 * */
public class MoodFragment extends Fragment implements ActivityGUI {

    private int layout;

    private View parentView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private MoodViewAdapter moodViewAdapter;

    private List<Mood> moods;

    public MoodFragment(){
        super();
        this.layout = R.layout.mood_fragment;
        this.moods = new ArrayList<>();

        moods.add(new Mood("Content(e)"));
        moods.add(new Mood("Triste"));
        moods.add(new Mood("En colère"));
        moods.add(new Mood("Stressé(e)"));
        moods.add(new Mood("Fatigué(e)"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.parentView = inflater.inflate(this.layout, container, false);
        this.setupGUI();
        return this.parentView;
    }
    @Override
    public void setupGUI() {

        this.recyclerView = this.parentView.findViewById(R.id.moodsRecyclerView);

        this.layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false );

        this.recyclerView.setLayoutManager(this.layoutManager);

        this.moodViewAdapter = new MoodViewAdapter();

        this.recyclerView.setAdapter(this.moodViewAdapter);

        this.moodViewAdapter.updateDataSet(this.moods);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
    }


}
