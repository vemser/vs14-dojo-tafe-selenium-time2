package automationexercise.page;

import automationexercise.factory.selenium.Interactions;
import org.openqa.selenium.By;

public class LoginPage extends Interactions {

    private static final By username =
    By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input");
    private static final By campoSenha =

    By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input");
    private static final By btnLogin =
    By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button");
    private static final By TextMsgmBtn =
    By.cssSelector("div.oxd-topbar-header > div.oxd-topbar-header-title > span > h6");
    private static final By msgmEmailIncorreto =
    By.cssSelector("div.oxd-alert.oxd-alert--error > div.oxd-alert-content.oxd-alert-content--error > p");
    private static final By requireUsername =
    By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > span");
    private static final By requirePassword =
    By.cssSelector("div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > span");

    private static final By esqueciSenhaBtn =
            By.cssSelector("div[class=\"orangehrm-login-forgot\"] p");

    private static final By inputUsernameEsqueciSenha =
            By.cssSelector("form[class=\"oxd-form\"] input[name=\"username\"]");
    private static final By btnEsqueciSenha =
            By.cssSelector("form > div.orangehrm-forgot-password-button-container > button.oxd-button.oxd-button--large.oxd-button--secondary.orangehrm-forgot-password-button.orangehrm-forgot-password-button--reset");
    private static final By btnCancelarEsqueciSenha =
            By.cssSelector("button.oxd-button.oxd-button--large.oxd-button--ghost.orangehrm-forgot-password-button.orangehrm-forgot-password-button--cancel");
    private static final By btnTextValidarEsqueciSenha =
            By.cssSelector("div[class=\"orangehrm-card-container\"] h6");
    private static final By VoltarPaginaLogin =
            By.cssSelector("form[action=\"/web/index.php/auth/validate\"]");
    private static final By textoPaginaLogin = By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > h5");

    public void preencherCampoEmail(String email){
        sendKeys(username,email);
    }
    public void preencherCampoSenha(String senha){
        sendKeys(campoSenha,senha);
    }
    public String validarTextoRequiredUsername(){return lerTexto(requireUsername);}
    public String validarTextoRequiredPassword(){return lerTexto(requirePassword);}
    public void clicarBtnAcessar(){
        click(btnLogin);
    }
    public String validarTextoBtnAposLogin(){
        return lerTexto(TextMsgmBtn);
    }
    public String validarMsgmEmailIncorreto(){
        return lerTexto(msgmEmailIncorreto);
    }

    public String btnValidarEsqueciSenha() {
        return lerTexto(btnTextValidarEsqueciSenha);
    }

    public String voltarPagina() {
        return lerTexto(VoltarPaginaLogin);
    }

    public void clicarBtnEsqueciMinhaSenha(){click(esqueciSenhaBtn);}
    public void preencherUsernameEsqueciSenha(String email){sendKeys(inputUsernameEsqueciSenha, email);}
    public void clicarBtnEsqueciSEnha(){click(btnEsqueciSenha);}
    public void clicarBtnCancelarSenha(){click(btnCancelarEsqueciSenha);}

    public String fazerLogin(String email, String senha){
        preencherCampoEmail(email);
        preencherCampoSenha(senha);
        click(btnLogin);
        return lerTexto(TextMsgmBtn);
    }
    public String loginEmailIncorreto(String email, String senha){
        preencherCampoEmail(email);
        preencherCampoSenha(senha);
        click(btnLogin);
        return lerTexto(msgmEmailIncorreto);
    }

    public String loginUsernameVazio(String email){
        preencherCampoEmail(email);
        return lerTexto(requireUsername);
    }

    public String loginSenha(String senha){
        preencherCampoEmail(senha);
        return lerTexto(requirePassword);
    }


    public String validarTextoPaginaLogin() {
        return lerTexto(textoPaginaLogin);
    }
}
