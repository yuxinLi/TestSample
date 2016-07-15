package com.example.testsample.dagger2;

import android.widget.EditText;

import com.example.testsample.BuildConfig;
import com.example.testsample.R;
import com.example.testsample.mockito.PasswordValidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * 作者：lyx on 2016/7/15 17:22
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class , sdk = 21)
public class LoginActivityTest {

    @Test
    public void testActivity(){
        TestUtils.setupDagger();
        LoginPresenter mockLP = mock(LoginPresenter.class);
        Mockito.when(TestUtils.appModule.providePresenter(any(UserManager.class) , any(PasswordValidator.class))).thenReturn(mockLP);

        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        ((EditText) loginActivity.findViewById(R.id.username)).setText("lyx");
        ((EditText) loginActivity.findViewById(R.id.password)).setText("111111");
        loginActivity.findViewById(R.id.login).performClick();

        verify(mockLP).login("lyx" , "111111");








    }


}
