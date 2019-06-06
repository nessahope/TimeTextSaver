package com.hope.nessa.texttimesaver.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hope.nessa.texttimesaver.MainFeedActivity;
import com.hope.nessa.texttimesaver.R;
import com.hope.nessa.texttimesaver.dao.UserDao;
import com.hope.nessa.texttimesaver.dao.UserFactory;
import com.hope.nessa.texttimesaver.model.User;


public class LoginFragment extends Fragment {

    private UserDao userDao;

    User user;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userDao = UserFactory.getUserdao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button login = view.findViewById(R.id.LoginTapped);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editTextUsername = getView().findViewById(R.id.editTextUsername);
                String username = editTextUsername.getText().toString();

                EditText editTextPassword = getView().findViewById(R.id.editTextPassword);

                try{
                    user = userDao.getUserByUsername(username);

                    Log.i("get", editTextPassword.getText().toString());
                    if(user.getPassword().equals(editTextPassword.getText().toString())){

                        Intent intent = new Intent(getContext(), MainFeedActivity.class);
                        startActivity(intent);
                    }
                } catch (Exception e){
                    Log.i("Error", e.getMessage());
                }

            }
        });

    }
}
