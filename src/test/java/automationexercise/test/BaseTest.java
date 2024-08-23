package automationexercise.test;

import automationexercise.factory.selenium.BrowserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest extends BrowserService {

    @BeforeEach
    public void abrirNavegador(){
        initChromeDriver("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterEach
    public void fecharNavegador(){
        quit();
    }

}
