package com.hope.nessa.texttimesaver;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.hope.nessa.texttimesaver.dao.UserDao;
import com.hope.nessa.texttimesaver.dao.UserFactory;
import com.hope.nessa.texttimesaver.fragment.LoginFragment;
import com.hope.nessa.texttimesaver.fragment.SignUpFragment;
import com.hope.nessa.texttimesaver.model.User;

public class RegisterActivity extends AppCompatActivity {

    private UserDao userDao;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        userDao = UserFactory.getUserdao();
        userDao.addUser(new User("a","a"));

        ConnectButtons();
    }

    private void ConnectButtons() {

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                LoginFragment loginFragment = new LoginFragment();
                fragmentTransaction.add(R.id.registrationContainer, loginFragment);
                fragmentTransaction.commit();

            }
        });

        Button btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                SignUpFragment signUpFragment = new SignUpFragment();
                fragmentTransaction.add(R.id.registrationContainer, signUpFragment);
                fragmentTransaction.commit();
            }
        });
    }

}
