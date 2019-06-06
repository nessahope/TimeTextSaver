package com.hope.nessa.texttimesaver.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hope.nessa.texttimesaver.R;
import com.hope.nessa.texttimesaver.dao.UserDao;
import com.hope.nessa.texttimesaver.dao.UserFactory;
import com.hope.nessa.texttimesaver.model.User;


public class SignUpFragment extends Fragment {

    private String PASSWORDS_DO_NOT_MATCH = "Passwords Do Not Match!";
    UserDao userDao;


    public SignUpFragment() {
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
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button registerbtn = view.findViewById(R.id.registerBtn);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = getView().findViewById(R.id.editTextUsernameSU);
                EditText password = getView().findViewById(R.id.editTextPasswordSU);
                String pass = password.getText().toString();
                if(checkPassword(pass)){
                    String user = username.getText().toString();

                    Toast.makeText(getContext(), "Test", Toast.LENGTH_SHORT).show();
                    userDao.addUser(new User(user, pass));
                    Log.i("users", userDao.getAll().toString());
                }

            }
        });


    }
    public Boolean checkPassword(String password){
        EditText editTextConfirm = getView().findViewById(R.id.editTextConfirmPassword);
        String confirm = editTextConfirm.getText().toString();
        Log.i("confirm", confirm);
        Log.i("password", password);
        if(!confirm.equals(password)){
            Toast.makeText(getContext(), PASSWORDS_DO_NOT_MATCH, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
