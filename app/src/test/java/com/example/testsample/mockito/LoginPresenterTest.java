package com.example.testsample.mockito;

import com.example.testsample.groupshare.NetworkCallback;
import com.example.testsample.what.UserManager;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

/**
 * 作者：lyx on 2016/7/15 11:49
 */
public class LoginPresenterTest {


    @Test
    public void testSpy(){
        PasswordValidator spyPv = Mockito.spy(PasswordValidator.class);
        boolean result = spyPv.verifyPassword("lyx");
        Assert.assertEquals(true , result);

        result = spyPv.verifyPassword("xxx");
        Assert.assertEquals(false , result);

        Mockito.when(spyPv.verifyPassword(anyString())).thenReturn(true);
        result = spyPv.verifyPassword("sss");
        Assert.assertTrue(result);


        Mockito.verify(spyPv , Mockito.times(2)).verifyPassword("lyx");
    }

    @Test
    public void testMockAnswer(){
        UserManager mockUserManager = Mockito.mock(UserManager.class);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                Object[] arguments = invocation.getArguments();
                NetworkCallback callbacks = (NetworkCallback) arguments[2];
                callbacks.onFailure(500 , "xxx");
                return 500;
            }
        }).when(mockUserManager).performLogin(anyString() , anyString() , any(NetworkCallback.class));

        mockUserManager.performLogin("lyx" , "111111" , Mockito.mock(NetworkCallback.class));
    }



    @Test
    public void testPassVal(){
        PasswordValidator pv = Mockito.mock(PasswordValidator.class);
        Mockito.when(pv.verifyPassword("lyx")).thenReturn(true);
        Assert.assertEquals(true , pv.verifyPassword("lyx"));

        Mockito.when(pv.verifyPassword(anyString())).thenReturn(true);
        Assert.assertEquals(true , pv.verifyPassword("xxx"));

    }



    @Test
    public void testLogin() throws Exception {
        UserManager mockUserManager = Mockito.mock(UserManager.class);
        // just for test
        LoginPresenter loginPresenter = new LoginPresenter(mockUserManager);

        loginPresenter.setUserManager(mockUserManager);
        loginPresenter.login("lyx" , "111111");

        Mockito.verify(mockUserManager).performLogin(anyString() , anyString());


    }

}