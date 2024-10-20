package br.com.leilao.leiloes;

import br.com.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage extends PageObject {
    private static final String URL_CADASTRO_LEILOES = "http://localhost:8080/leiloes/NEW";

    public CadastroLeilaoPage(WebDriver browser) {
        super(browser);
    }


    public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
        browser.findElement(By.id("nome")).sendKeys(nome);
        browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        browser.findElement(By.id("button-submit")).submit();

        return new LeiloesPage(browser);
    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().equals(URL_CADASTRO_LEILOES);
    }

    public boolean isMensagemDeValidacaoVisiveis() {
        String pageSource = browser.getPageSource();
        return pageSource.contains("não deve estar em branco")
                && pageSource.contains("minimo 3 caracteres")
                && pageSource.contains("deve ser um valor maior de 0.1")
                && pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }
}