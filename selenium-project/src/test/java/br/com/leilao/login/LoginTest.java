package br.com.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage paginaDeLogin;

    private static final String URL_LOGIN_ERROR = "http://localhost:8080/login?error";

    private static final String USER_CORRECT = "fulano";
    private static final String PASSWD_CORRECT = "pass";

    private static final String USER_INCORRECT = "fulanos";
    private static final String PASSWD_INCORRECT = "pass123";

    private static final String MSG_INVALID_LOGIN = "Usuário e senha inválidos";


    @BeforeEach
    public void beforeEach() {
        this.paginaDeLogin = new LoginPage();
    }


    @AfterEach
    public void afterEach() {
        this.paginaDeLogin.quit();
    }

    @Test
    public void deveriaEfeturaLoginComDadosValidos() {
        paginaDeLogin.preencheFormularioDeLogin(USER_CORRECT, PASSWD_CORRECT);
        paginaDeLogin.efetuaLogin();

        Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
        Assert.assertEquals(USER_CORRECT, paginaDeLogin.getNomeUsuarioLogado());
    }

    @Test
    public void naoDeveriaEfeturaLoginComDadosInvalidos() {
        paginaDeLogin.preencheFormularioDeLogin(USER_INCORRECT, PASSWD_INCORRECT);
        paginaDeLogin.efetuaLogin();

        Assert.assertTrue(paginaDeLogin.isPagina(URL_LOGIN_ERROR));
        Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
        Assert.assertTrue(paginaDeLogin.contemTexto(MSG_INVALID_LOGIN));
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        paginaDeLogin.navegaParaPaginaDeLances();

        Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leil"));

    }
}