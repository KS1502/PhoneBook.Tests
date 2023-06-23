package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
     //int i =(int) (System.currentTimeMillis() / 100)%3600; mozhno potom dobavljatj
     // potom i peremenuju vesde i budet menjatza telefonnummer
    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
        //click on Login link
        app.getHeader().clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        //enter email field
        //enter password field
        app.getUser().fillLoginRegistrationForm(new User().setEmail("kan@gmai.com").setPassword("Kan123$-_$"));
        //click on Registration
        app.getUser().clickOnRegistrationButton();
        //assert user logged in(check Sign Out button displayed)
        Assert.assertTrue(app.getContact().isAlertPresent());
    }


}
