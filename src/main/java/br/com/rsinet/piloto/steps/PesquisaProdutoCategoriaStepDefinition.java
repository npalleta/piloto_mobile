package br.com.rsinet.piloto.steps;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rsinet.framework_bdd.driver.SharedDriver;
import br.com.rsinet.piloto.screens.TelaPesquisaProduto;
import br.com.rsinet.piloto.screens.TelaPrincipal;
import br.com.rsinet.piloto.screens.TelaProduto;
import cucumber.api.java.an.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PesquisaProdutoCategoriaStepDefinition {

	private TelaPrincipal telaPrincipal;
	private TelaPesquisaProduto telaPesquisaProduto;
	private TelaProduto telaProduto;

	@Autowired
	public PesquisaProdutoCategoriaStepDefinition(SharedDriver sharedDriver) {
		this.telaPrincipal = new TelaPrincipal(sharedDriver.getDriver());
		this.telaPesquisaProduto = new TelaPesquisaProduto(sharedDriver.getDriver());
		this.telaProduto = new TelaProduto(sharedDriver.getDriver());
	}

	@Quando("eu escolho a categoria {string}")
	public void escolhoCategoria(String categoria) {
		telaPrincipal.clicarNaCategoria(categoria);
	}

	@E("seleciono o produto {string}")
	public void selecionoProduto(String produto) {
		telaPesquisaProduto.clicarNoProduto(produto);
	}

	@Entao("verifico se a tela do produto {string} é apresentada")
	public void verificoTelaProduto(String nomeProduto) {
		this.telaProduto.validarNomeProduto(nomeProduto);
	}
}
