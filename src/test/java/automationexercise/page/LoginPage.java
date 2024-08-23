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
    By.cssSelector("div.orangehrm-login-container  div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > span");
    private static final By requirePassword =
    By.cssSelector("div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > span");

    public void preencherCampoEmail(String email){
        sendKeys(username,email);
    }

    public void preencherCampoSenha(String senha){
        sendKeys(campoSenha,senha);
    }


    public void clicarBtnAcessar(){
        click(btnLogin);
    }
    public String validarTextoBtnAposLogin(){
        return lerTexto(TextMsgmBtn);
    }
    public String validarMsgmEmailIncorreto(){
        return lerTexto(msgmEmailIncorreto);
    }

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


}
