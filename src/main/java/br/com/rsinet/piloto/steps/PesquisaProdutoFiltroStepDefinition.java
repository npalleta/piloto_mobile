package br.com.rsinet.piloto.steps;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rsinet.framework_bdd.driver.SharedDriver;
import br.com.rsinet.piloto.screens.TelaPrincipal;
import cucumber.api.java.an.E;
import cucumber.api.java.pt.Quando;

public class PesquisaProdutoFiltroStepDefinition {

	private TelaPrincipal telaPrincipal;

	@Autowired
	public PesquisaProdutoFiltroStepDefinition(SharedDriver sharedDriver) {
		this.telaPrincipal = new TelaPrincipal(sharedDriver.getDriver());
	}

	@Quando("eu digito o {string} no campo search")
	public void euDigitoProdutoCampoSearch(String produto) {
		telaPrincipal.digitarProduto(produto);
	}

	@E("clico no botão search")
	public void clinaNoBotaoSearch() {
		telaPrincipal.clicarPesquisaProduto();
	}
}
