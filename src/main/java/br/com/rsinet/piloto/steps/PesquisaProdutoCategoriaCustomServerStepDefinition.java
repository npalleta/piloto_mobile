package br.com.rsinet.piloto.steps;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rsinet.framework_bdd.driver.SharedDriver;
import br.com.rsinet.piloto.screens.TelaOffline;
import cucumber.api.java.pt.Dado;

public class PesquisaProdutoCategoriaCustomServerStepDefinition {

	private TelaOffline telaOffline;

	@Autowired
	public PesquisaProdutoCategoriaCustomServerStepDefinition(SharedDriver sharedDriver) {
		this.telaOffline = new TelaOffline(sharedDriver.getDriver());
	}

	@Dado("que a aplicação está configurada para o servidor {string}")
	public void aplicacao_modo_offline(String servidor) {
		this.telaOffline.validarModoOffline();
		this.telaOffline.digitarValorServer(servidor);
		this.telaOffline.clicarNoBotaoApply();
		this.telaOffline.confirmarEscolhaModoOffline();
	}
}
