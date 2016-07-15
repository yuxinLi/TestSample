package com.example.testsample.dagger2;

import com.example.testsample.mockito.PasswordValidator;

import javax.inject.Inject;

public class LoginPresenter {
    private final UserManager mUserManager;
    private final PasswordValidator mPasswordValidator;

    @Inject
    public LoginPresenter(UserManager userManager, PasswordValidator passwordValidator) {
        this.mUserManager = userManager;
        this.mPasswordValidator = passwordValidator;
    }

    public void login(String username, String password) {
        if (username == null || username.length() == 0) return;
        if (!mPasswordValidator.verifyPassword(password)) return;

        mUserManager.performLogin(username, password);
    }

    public boolean isLoggedIn() {
        return false;
    }

}