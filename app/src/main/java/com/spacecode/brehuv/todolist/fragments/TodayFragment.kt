package com.spacecode.brehuv.todolist.fragments


import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar

import com.spacecode.brehuv.todolist.R
import com.spacecode.brehuv.todolist.task.AddTaskActivity
import com.spacecode.brehuv.todolist.utils.ProgressUtil

/**
 * A simple [Fragment] subclass.
 */
class TodayFragment : Fragment() {

    private var mProgressBar: ProgressBar? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_today, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_button)
        fab.setOnClickListener {
            val addTODO = Intent(activity, AddTaskActivity::class.java)
            startActivity(addTODO)
            activity!!.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        mProgressBar = view.findViewById(R.id.progress_bar)
        ProgressUtil.increaseProgress(mProgressBar!!, 67)

        return view
    }

    companion object {

        /**
         * Create instance of fragment.
         */
        fun newInstance(): TodayFragment {
            return TodayFragment()
        }
    }

}// Required empty public constructor
