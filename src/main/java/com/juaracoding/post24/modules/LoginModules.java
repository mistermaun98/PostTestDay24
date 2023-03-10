package com.juaracoding.post24.modules;

import com.juaracoding.post24.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginModules {
    private WebDriver driver;

    public LoginModules(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement userMenu;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutBtn;
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement txtDashboard;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement txtInvalidCredentials;

    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[2]//div[1]//span[1]")
    WebElement emptyPassword;

    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[2]//div[1]//span[1]")
    WebElement emptyUsername;

    public String getTxtDashboard(){
        return txtDashboard.getText();
    }

    public String getTxtInvalidCredentials(){
        return txtInvalidCredentials.getText();
    }

    public String getEmptyPasswordError() {
        return emptyPassword.getText();
    }

    public String getEmptyUsernameError() {
        return emptyUsername.getText();
    }

    public void enterUsername(String username){
        this.username.sendKeys(username);
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void buttonLoginClick(){
        btnLogin.click();
    }

    public void logout() {
        userMenu.click();
        logoutBtn.click();
    }
}
