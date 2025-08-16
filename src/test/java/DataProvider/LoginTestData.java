package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestData {

    @Test(dataProvider="loginData")

    public void loginTest(String username, String password){
        System.out.println("Logging with="+ username+" "+password);
    }

    @DataProvider(name="loginData")

    public Object[][] getData(){

        Object [][] data = new Object[3][2];
        data[0][0] = "firstusername";
        data[0][1] = "password1";
        data[1][0] = "secondusername";
        data[1][1] = "password2";
        data[2][0] = "firstusername";
        data[2][1] = "password3";
        return data;
    }


}
