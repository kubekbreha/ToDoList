package com.spacecode.brehuv.todolist.task

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.cloudant.sync.documentstore.AttachmentException
import com.cloudant.sync.documentstore.ConflictException
import com.cloudant.sync.documentstore.DocumentBodyFactory
import com.cloudant.sync.documentstore.DocumentNotFoundException
import com.cloudant.sync.documentstore.DocumentRevision
import com.cloudant.sync.documentstore.DocumentStore
import com.cloudant.sync.documentstore.DocumentStoreException
import com.cloudant.sync.documentstore.UnsavedFileAttachment
import com.spacecode.brehuv.todolist.R

import java.io.File
import java.net.URI
import java.net.URISyntaxException
import java.util.HashMap

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
    }
}
