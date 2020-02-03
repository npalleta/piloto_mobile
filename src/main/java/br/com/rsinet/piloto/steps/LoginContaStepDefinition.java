package br.com.rsinet.piloto.steps;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rsinet.framework_bdd.driver.SharedDriver;
import br.com.rsinet.piloto.screens.TelaLogin;
import br.com.rsinet.piloto.screens.TelaPrincipal;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class LoginContaStepDefinition {

	private TelaPrincipal telaPrincipal;
	private TelaLogin telaLogin;

	@Autowired
	public LoginContaStepDefinition(SharedDriver sharedDriver) {
		this.telaPrincipal = new TelaPrincipal(sharedDriver.getDriver());
		this.telaLogin = new TelaLogin(sharedDriver.getDriver());
	}

	@E("na tela de login digito nome de usuario {string} e senha {string}")
	public void digito_nome_usuario(String nomeUsuario, String senha) {
		this.telaLogin.digitarNomeUsuario(nomeUsuario);
		this.telaLogin.digitarSenha(senha);
	}

	@Quando("clico no botão LOGIN")
	public void clico_botao_LOGIN() {
		this.telaLogin.clicarEmLogin();
	}

	@Entao("valido se o usuário {string} com o nome {string} está logado")
	public void validar_cadastro(String usuario, String nomeUsuario) {
		this.telaPrincipal.clicarNoMenu();
		this.telaPrincipal.validarUsuarioLogado(usuario, nomeUsuario);
	}
}
