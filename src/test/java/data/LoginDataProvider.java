package data;

import ca.pragra.wd2.framwork.data.ExcelDataProvider;
import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class LoginDataProvider {

    @DataProvider(name = "loginProvider")
    public Iterator<Object[]> getLoginData(){
        ExcelDataProvider excelDataProvider  = new ExcelDataProvider();
        return excelDataProvider.getData("Login",true).iterator();
    }
}
