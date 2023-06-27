package com.tests;


import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase{
 @BeforeMethod
    public void RemovesContact() {
     app.getHeader().clickOnLoginLink();
     app.getUser().fillLoginRegistrationForm(new User()
             .setEmail("kan@gmai.com")
             .setPassword("Kan123$-_$"));
     app.getUser().clickOnLoginButton();
    // app.getHeader().clickOnAddLink();
     app.getContact().removeContact();
     app.getHeader().clickOnSignOutButton();
 }

    @Test
    public void RemoveContact(){

     int sizeBefore = app.getContact().sizeOfContacts();
     System.out.println(sizeBefore);

     app.getContact().removeContact();
     app.getContact().pause(1000);

     int sizeAfter = app.getContact().sizeOfContacts();
     System.out.println(sizeAfter);

     Assert.assertEquals(sizeAfter,sizeBefore-1);
    }
}
/* Создайте, пожалуйста, класс RemoveContactTest, где будет содержаться метод, проверяющий
    удаление контакта(все остальные действия следует вынести в @BeforeMethod).
    Попытайтесь написать Assert
    // gradlew -Pbrowser=firefox clean qa1 -Psuite1
    */
