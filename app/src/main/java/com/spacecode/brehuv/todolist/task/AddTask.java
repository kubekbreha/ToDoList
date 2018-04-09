package com.spacecode.brehuv.todolist.task;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.spacecode.brehuv.todolist.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class AddTask extends AppCompatActivity {

    private Button mButtonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_todo);
        getSupportActionBar().hide();

        mButtonSubmit = findViewById(R.id.new_todo_button);

        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOneTask();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    private void addOneTask(){
        final String[] REV = {null};
        String url = "https://cloudantUsername.cloudant.com/todolist";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("_id", "Document Id What-Ever you want");
        map.put("twitter_feeds", "Your Data");

        JsonObjectRequest jar1 = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(map), new  com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    REV[0] = jsonObject.getString("rev");
                } catch (JSONException e) {
                }
            }
        }, new  com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Json Error Res: ", "" + error);
            }
        });
        requestQueue.add(jar1);

    }



}
