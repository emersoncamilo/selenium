package br.com.leilao.leiloes;

import br.com.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage extends PageObject {

    private static final String URL_CADASTRO_LEILOES = "http://localhost:8080/leiloes/NEW";
    private static final String URL_LEILOES = "http://localhost:8080/leiloes";


    public LeiloesPage(WebDriver browser) {
        super(browser);
    }

    public CadastroLeilaoPage carregaFormulario() {
        browser.findElement(By.id("novo_leilao_link")).click();
        return new CadastroLeilaoPage(browser);
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String dataAbertura) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#table-auction tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));

        return colunaNome.getText().equals(nome)
                && colunaValorInicial.getText().equals(valor)
                && colunaDataAbertura.getText().equals(dataAbertura);

    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().equals(URL_LEILOES);
    }
}