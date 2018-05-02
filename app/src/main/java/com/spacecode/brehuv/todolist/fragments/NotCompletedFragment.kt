package com.spacecode.brehuv.todolist.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.spacecode.brehuv.todolist.R


/**
 * A simple [Fragment] subclass.
 */
class NotCompletedFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_not_completed, container, false)
    }

    companion object {

        /**
         * Create instance of fragment.
         */
        fun newInstance(): NotCompletedFragment {
            return NotCompletedFragment()
        }
    }

}// Required empty public constructor
