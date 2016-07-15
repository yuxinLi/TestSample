package com.example.testsample.dagger2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.testsample.R;

import javax.inject.Inject;

/**
 * 作者：lyx on 2016/7/15 15:43
 */
public class LoginActivity extends AppCompatActivity{

    @Inject
    LoginPresenter mLoginPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        ComponentHolder.getAppComponent().inject(this);

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText) findViewById(R.id.username)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
                mLoginPresenter.login(username, password);
            }
        });

    }
}
