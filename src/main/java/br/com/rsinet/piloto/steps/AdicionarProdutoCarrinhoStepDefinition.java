package br.com.rsinet.piloto.steps;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rsinet.framework_bdd.driver.SharedDriver;
import br.com.rsinet.piloto.screens.TelaProduto;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;

public class AdicionarProdutoCarrinhoStepDefinition {

	private TelaProduto telaProduto;
	
	@Autowired
	public AdicionarProdutoCarrinhoStepDefinition(SharedDriver sharedDriver) {
		this.telaProduto = new TelaProduto(sharedDriver.getDriver());
	}	

	@E("adiciono o produto ao carrinho")
	public void adiciono_produto_carrinho() {
		this.telaProduto.adicionarProdutoCarrinho();
	}

	@Entao("valido se o produto {string} foi adicionado ao carrinho")
	public void valido_se_produto_foi_adicionado_carrinho(String nomeProduto) {
		this.telaProduto.validarProdutoCarrinho(nomeProduto);
	}
}
