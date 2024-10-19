package br.com.leilao.leiloes;

import br.com.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest {
    private LeiloesPage paginaDeLeiloes;
    private CadastroLeilaoPage paginaDeCadastro;
    private static final String USER_CORRECT = "fulano";
    private static final String PASSWD_CORRECT = "pass";

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencheFormularioDeLogin(USER_CORRECT, PASSWD_CORRECT);
        this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
        this.paginaDeCadastro = this.paginaDeLeiloes.carregaFormulario();

    }


    @AfterEach
    public void afterEach() {
        this.paginaDeLeiloes.quit();
    }


    @Test
    public void deveriaCadastrarLeilao() {
        // Data form
        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilao do dia " + hoje + "_" + System.currentTimeMillis();
        String valor = "545.00";

        this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);

        Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));

    }




    @Test
    public void DeveriaValidarCadastroDeLeilao(){
        this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("", "", "");
        Assert.assertFalse(this.paginaDeCadastro.isPaginaAtual());
        Assert.assertTrue(this.paginaDeLeiloes.isPaginaAtual());
        Assert.assertTrue(this.paginaDeCadastro.isMensagemDeValidacaoVisiveis());

    }

}
