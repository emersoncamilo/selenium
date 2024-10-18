package br.com.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private static final String URL_LOGIN = "http://localhost:8080/login";
    private static final String URL_LOGIN_ERROR = "http://localhost:8080/login?error";
    private static final String URL_LEILOES_ID_2 = "http://localhost:8080/leiloes/2";

    private static final String USER_CORRECT = "fulano";
    private static final String PASSWD_CORRECT = "pass";

    private static final String USER_INCORRECT = "fulanos";
    private static final String PASSWD_INCORRECT = "pass123";

    private static final String MSG_INVALID_LOGIN = "Usuário e senha inválidos";

    private WebDriver browser;

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "others\\drivers\\chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach() {
        this.browser = new ChromeDriver();
        browser.navigate().to(URL_LOGIN);
    }

    @AfterEach
    public void afterEach() {
        browser.quit();
    }


    @Test
    public void deveriaEfeturaLoginComDadosValidos() {

        browser.findElement(By.id("username")).sendKeys(USER_CORRECT);
        browser.findElement(By.id("password")).sendKeys(PASSWD_CORRECT);
        waitTime(1000L);
        browser.findElement(By.id("login-form")).submit();
//        browser.findElement(By.id("submit-button")).click();
        waitTime(1000L);
        Assert.assertFalse(browser.getCurrentUrl().equals(URL_LOGIN));
        Assert.assertEquals(USER_CORRECT, browser.findElement(By.id("usuario-logado")).getText());
    }

    @Test
    public void naoDeveriaEfeturaLoginComDadosValidos() {
        browser.findElement(By.id("username")).sendKeys(USER_INCORRECT);
        browser.findElement(By.id("password")).sendKeys(PASSWD_INCORRECT);

        browser.findElement(By.id("login-form")).submit();

        Assert.assertTrue(browser.getCurrentUrl().equals(URL_LOGIN_ERROR));
        Assert.assertTrue(browser.getPageSource().contains(MSG_INVALID_LOGIN));
        Assert.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")).getText());
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        browser.navigate().to(URL_LEILOES_ID_2);

        Assert.assertTrue(browser.getCurrentUrl().equals(URL_LOGIN));
        Assert.assertFalse(browser.getPageSource().contains("Dados do Leil"));

    }



    private void waitTime(Long ms) {
        ms = 0l;
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}