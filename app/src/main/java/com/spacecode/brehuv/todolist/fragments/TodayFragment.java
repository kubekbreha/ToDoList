package com.spacecode.brehuv.todolist.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.spacecode.brehuv.todolist.task.AddTask;
import com.spacecode.brehuv.todolist.R;
import com.spacecode.brehuv.todolist.utils.ProgressUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment extends Fragment {

    private ProgressBar mProgressBar;

    public TodayFragment() {
        // Required empty public constructor
    }

    /**
     * Create instance of fragment.
     */
    public static TodayFragment newInstance() {
        TodayFragment fragment = new TodayFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_today, container, false);

        FloatingActionButton fab =  view.findViewById(R.id.fab_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addTODO = new Intent(getActivity(), AddTask.class);
                startActivity(addTODO);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        mProgressBar = view.findViewById(R.id.progress_bar);
        ProgressUtil.increaseProgress(mProgressBar, 67);

        return view;
    }

}
