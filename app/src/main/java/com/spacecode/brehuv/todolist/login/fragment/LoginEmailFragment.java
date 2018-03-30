/*
* Copyright 2018 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.spacecode.brehuv.todolist.login.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.spacecode.brehuv.todolist.MainActivity;
import com.spacecode.brehuv.todolist.R;

import java.util.Objects;

/**
 * Created by kubek on 3/29/18.
 * A simple {@link Fragment} subclass.
 */
public class LoginEmailFragment extends Fragment {

    private EditText mLoginEmailField;
    private EditText mLoginPasswordField;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private ProgressDialog mProgres;

    public LoginEmailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_email, container, false);

        RelativeLayout mRelativeLayout = view.findViewById(R.id.email_login_gradient);
        Button mLoginButton = view.findViewById(R.id.login_email_button);
        mLoginEmailField = view.findViewById(R.id.login_email);
        mLoginPasswordField = view.findViewById(R.id.login_password);

        AnimationDrawable mAnimationDrawable = (AnimationDrawable) mRelativeLayout.getBackground();
        mAnimationDrawable.setEnterFadeDuration(4500);
        mAnimationDrawable.setExitFadeDuration(4500);
        mAnimationDrawable.start();

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("users");

        mProgres = new ProgressDialog(getContext());
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }

        });

        return view;
    }

    /**
     * Login via email, and get result if succeed or failed.
     */
    private void checkLogin() {
        String email = mLoginEmailField.getText().toString().trim();
        String password = mLoginPasswordField.getText().toString().trim();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mProgres.setMessage("Checking Login");
            mProgres.show();
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        mProgres.dismiss();
                        checkUserExist();
                    } else {
                        mProgres.dismiss();
                        Toast.makeText(getActivity(), "Failed to login", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /**
     * Checking if user already exist in database.
     * If not send user to SetupActivity.
     */
    private void checkUserExist() {
        final String userId = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    updateUI();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * Open MainActivity.
     * Called when user is authenticated.
     */
    private void updateUI() {
        Intent accountIntent = new Intent(getActivity(), MainActivity.class);
        startActivity(accountIntent);
        Objects.requireNonNull(getActivity()).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        getActivity().finish();
    }

}
