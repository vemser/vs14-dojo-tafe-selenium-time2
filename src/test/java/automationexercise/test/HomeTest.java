package automationexercise.test;

import automationexercise.dto.LoginDto;
import automationexercise.factory.data.LoginData;
import automationexercise.factory.selenium.Validation;
import automationexercise.page.LoginPage;
import automationexercise.page.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest {

LoginPage loginPage = new LoginPage();
LoginData loginData = new LoginData();
HomePage homePage = new HomePage();
Validation validation = new Validation();


@BeforeEach
public void setUp() {
    LoginDto usu =  loginData.loginDadosValidos();
    loginPage.preencherCampoEmail(usu.getEmail());
    loginPage.preencherCampoSenha(usu.getSenha());
    loginPage.clicarBtnAcessar();
}

    @Test
    public void testBuscaMenuLateral(){

        String texto = homePage.buscarCategoria();
        validation.validateText("Admin", texto);
    }

    @Test
    public void testMostrarFuncionalidadeAdmin() {
        String texto = homePage.mostrarAdmin();
        validation.validateText("System Users", texto);
        
    }

	@Test
    public void testBuscarUsuario() {
        homePage.buscarUsuario();
        homePage.clicarBtnBuscarUsuario();
        String nomeEncontrado = homePage.mostrarUsuarioencontrado();
        validation.validateText("(1) Record Found", nomeEncontrado);
    }

    @Test
    public void testAddUsuarioInvalido() {
        homePage.mostrarAdmin();
        homePage.clicarBtnAdd();
        homePage.preencherAdmin();
//        homePage.preencherStatus(1);
        homePage.preencherNome();
        homePage.preencherPassowrd();
        homePage.preencherConfirmPassowrd();
        homePage.clicarBtnSave();

        validation.validateText(homePage.validEmpolyText(), "Required");
    }
}
