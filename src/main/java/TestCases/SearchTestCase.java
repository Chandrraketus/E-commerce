package TestCases;

import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;
import pages.SearchPages;
import utilities.ReadExcelFile;

public class SearchTestCase extends BaseClass {
    @Test
    public void searchProduct() {
        lp= new LoginPage(driver);
        lp.portalLogin(User,Password);
        String fileName = "path/to/excel/file.xlsx"; // Update with your Excel file path
        String searchQuery = ReadExcelFile.getCellValue(fileName, "Search", 0, 0);

        SearchPages sp = new SearchPages(driver);
        sp.searchProduct(searchQuery);
    }
}
