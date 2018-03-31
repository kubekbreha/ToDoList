package com.spacecode.brehuv.todolist.main.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spacecode.brehuv.todolist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotCompletedFragment extends Fragment {


    public NotCompletedFragment() {
        // Required empty public constructor
    }

    /**
     * Create instance of fragment.
     */
    public static NotCompletedFragment newInstance() {
        NotCompletedFragment fragment = new NotCompletedFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_not_completed, container, false);
    }

}
