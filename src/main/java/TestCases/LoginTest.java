package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;
import utilities.ReadExcelFile;

import java.io.IOException;

public class LoginTest extends BaseClass {
    String FileName = System.getProperty("user.dir") + "\\TestData\\ETestData.xlsx";

    @Test(dataProvider = "loginDataProvider")

    public void verify(String User, String Password) throws InterruptedException, IOException {
        LoginPage lp = new LoginPage(driver);
        lp.portalLogin(User, Password);
        Thread.sleep(2000);
        if (User.equals("sharma123ronit@gmail.com") && Password.equals("Ronit@123")) {
            Assert.assertTrue(true);

            lp.logout();


        }

        else
        {
            capturesreenshot(driver,"Verify");
            Assert.assertTrue(false);

        }



    }
        @DataProvider
        public String[][] loginDataProvider ()
        {
            int row = ReadExcelFile.getRowCount(FileName, "Login");
            int col = ReadExcelFile.getColCount(FileName, "Login");
            String[][] data = new String[row - 1][col];

            for (int i = 1; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    data[i - 1][j] = ReadExcelFile.getCellValue(FileName, "Login", i, j);

                }
            }
            return data;


        }
    }
