package automationexercise.test;

import automationexercise.dto.LoginDto;
import automationexercise.factory.data.LoginData;
import automationexercise.factory.selenium.Validation;
import automationexercise.page.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static storys.LoginStory.*;

@Epic(EPIC)
@Story(USER_STORY_LOGIN)
public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();
    Validation validation = new Validation();

    @Test
    @Description(CE_LOGIN_01)
    public void test1validarLoginDadosValidos(){
        LoginDto usu =  loginData.loginDadosValidos();     // <- Gerando massa de dados
        loginPage.preencherCampoEmail(usu.getEmail());
        loginPage.preencherCampoSenha(usu.getSenha());
        loginPage.clicarBtnAcessar();
        String msgm = loginPage.validarTextoBtnAposLogin();
        validation.validateText(msgm,"Dashboard");
    }

    @Test
    @Description(CE_LOGIN_02)
    public void test2validarLoginDadosInvalidos(){
        LoginDto usu =  loginData.LoginDadoDinamicos();
        loginPage.preencherCampoEmail(usu.getEmail());
        loginPage.preencherCampoSenha(usu.getSenha());
        loginPage.clicarBtnAcessar();
        String msgm = loginPage.validarMsgmEmailIncorreto();
        validation.validateText(msgm,"Invalid credentials");
    }

    @Test
    public void testUsernameVazio(){
        LoginDto login = loginData.loginDadosValidos();
        login.setEmail("");
        login.setSenha("");
        loginPage.preencherCampoEmail(login.getEmail());
        loginPage.preencherCampoSenha(login.getSenha());
        loginPage.clicarBtnAcessar();
        validation.validateText(loginPage.validarTextoRequiredUsername(), "Required");
        validation.validateText(loginPage.validarTextoRequiredPassword(), "Required");

    }

    @Test
    public void testEsqueciSenha(){
        loginPage.clicarBtnEsqueciMinhaSenha();
        loginPage.preencherUsernameEsqueciSenha("Admin");
        String msg = loginPage.btnValidarEsqueciSenha();
        validation.validateText(msg, "Reset Password link sent successfully");

    }

    @Test
    public void testEsqueciSenhaCancelar(){
        loginPage.clicarBtnEsqueciMinhaSenha();
        loginPage.preencherUsernameEsqueciSenha("Admin");
        loginPage.clicarBtnCancelarSenha();
        String texto = loginPage.validarTextoPaginaLogin();

        validation.validateText(texto, "Login");
    }

}
