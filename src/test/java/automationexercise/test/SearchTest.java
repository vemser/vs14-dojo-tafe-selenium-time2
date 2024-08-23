package automationexercise.test;

import automationexercise.dto.LoginDto;
import automationexercise.factory.data.LoginData;
import automationexercise.page.LoginPage;
import automationexercise.page.SearchPage;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {

LoginPage loginPage = new LoginPage();
LoginData loginData = new LoginData();
SearchPage searchPage = new SearchPage();

@Test
    public void testBuscaMenuLateral(){
    LoginDto usu =  loginData.loginDadosValidos();
    loginPage.preencherCampoEmail(usu.getEmail());
    loginPage.preencherCampoSenha(usu.getSenha());
    loginPage.clicarBtnAcessar();


}



}
