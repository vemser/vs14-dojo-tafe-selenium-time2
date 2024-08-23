package automationexercise.page;

import automationexercise.factory.selenium.Interactions;
import org.openqa.selenium.By;

public class HomePage extends Interactions {

    public static final By btnAdd = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-header-container > button");
    public static final By inputAdmin = By.cssSelector("html > body > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > div > div > form > div:nth-of-type(1) > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div > div:nth-of-type(1)");
    public static final By inputStatus = By.cssSelector("div[class='oxd-select-text oxd-select-text--focus'] div[tabindex='0']");

    public static final By labelUserName = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(4) > div > div:nth-child(2) > input");
    public static final By labelPassword = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div.oxd-grid-item.oxd-grid-item--gutters.user-password-cell > div > div:nth-child(2) > input");
    public static final By labelConfirmPassword = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div:nth-child(2) > div > div:nth-child(2) > input");

    public static final By btnSave = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");


    public static final By searchField = By.cssSelector(".oxd-input");

    public static final By adminButton = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(1) > a > span");

    public static final By adminTitle = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-header > div.oxd-table-filter-header-title > h5");
    public static final By usernameField = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(1) > div > div:nth-child(2) > input");
    public static final By btnSearch = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");
    public static final By txtUsuarioEncontrado = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div:nth-child(2) > div > span");


    public String buscarCategoria() {
        sendKeys(searchField, "Admin");

        return lerTexto(adminButton);
    }

    public void buscarUsuarioSistema() {

    }

    public String mostrarAdmin() {
        click(adminButton);

        return lerTexto(adminTitle);
    }

    public void buscarUsuario() {
        click(adminButton);
        sendKeys(usernameField, "Admin");
    }
    public  void clicarBtnBuscarUsuario(){
        click(btnSearch);
    }
    public String mostrarUsuarioencontrado() {
        return lerTexto(txtUsuarioEncontrado)
;
    }

//    public String  addUsuarioInvalido(){
//        click(btnSave);
//    }

    public void clicarBtnAdd() {
        click(btnAdd);
    }

    public void clicarBtnSave(){
        click(btnSave);
    }

    public void preencherAdmin(int index) {
        selectByValue(inputAdmin, index);
    }

    public void preencherStatus(int index) {
        selectByValue(inputStatus, index);
    }

    public void preencherNome(){
        sendKeys(labelUserName, "Matheus");
    }

    public void preencherPassowrd(){
        sendKeys(labelPassword, "12345Test");
    }

    public void preencherConfirmPassowrd(){
        sendKeys(labelConfirmPassword, "12345Test");
    }
}
