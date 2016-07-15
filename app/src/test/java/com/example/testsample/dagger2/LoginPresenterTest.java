package com.example.testsample.dagger2;

import com.example.testsample.BuildConfig;
import com.example.testsample.mockito.PasswordValidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * 作者：lyx on 2016/7/15 16:30
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class , sdk = 21)
public class LoginPresenterTest {


    @Test
    public void testLoginDagger(){
        TestUtils.setupDagger();
        UserManager mockUM = mock(UserManager.class);
        Mockito.when(TestUtils.appModule.provideUserManager()).thenReturn(mockUM);

        LoginPresenter presenter = ComponentHolder.getAppComponent().loginPresenter();
        presenter.login("lyx" , "111111");

        verify(mockUM).performLogin("lyx","111111");
    }



    @Test
    public void testLogin() throws Exception {
        UserManager mockUM = mock(UserManager.class);
        LoginPresenter preenter = new LoginPresenter(mockUM , new PasswordValidator());

        preenter.login("lyx" , "111111");

        verify(mockUM).performLogin("lyx" , "111111");

    }
}
























