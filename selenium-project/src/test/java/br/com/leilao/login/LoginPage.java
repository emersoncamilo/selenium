package br.com.leilao.login;

import br.com.leilao.PageObject;
import br.com.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends PageObject {

    private static final String URL_LOGIN = "http://localhost:8080/login";
    private static final String URL_LEILOES_ID_2 = "http://localhost:8080/leiloes/2";

    public LoginPage() {
        super(null);
        browser.navigate().to(URL_LOGIN);

    }

    public void preencheFormularioDeLogin(String userCorrect, String passwdCorrect) {
        browser.findElement(By.id("username")).sendKeys(userCorrect);
        browser.findElement(By.id("password")).sendKeys(passwdCorrect);

    }

    public LeiloesPage efetuaLogin() {
        browser.findElement(By.id("login-form")).submit();
//      browser.findElement(By.id("submit-button")).click();
        //redicrect to ../leiloes
        return new LeiloesPage(browser);

    }

    public boolean isPaginaDeLogin() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public String getNomeUsuarioLogado() {
        try {
            return browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void navegaParaPaginaDeLances() {
        browser.navigate().to(URL_LEILOES_ID_2);


    }

    public boolean contemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }

    public boolean isPagina(String urlLoginError) {
        return browser.getCurrentUrl().equals(urlLoginError);
    }
}