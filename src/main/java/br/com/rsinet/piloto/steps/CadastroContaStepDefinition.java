package br.com.rsinet.piloto.steps;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rsinet.framework_bdd.driver.SharedDriver;
import br.com.rsinet.piloto.screens.TelaCadastro;
import br.com.rsinet.piloto.screens.TelaLogin;
import br.com.rsinet.piloto.screens.TelaPrincipal;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.pt.Quando;

public class CadastroContaStepDefinition {

	private TelaPrincipal telaPrincipal;
	private TelaLogin telaLogin;
	private TelaCadastro telaCadastro;

	@Autowired
	public CadastroContaStepDefinition(SharedDriver sharedDriver) {
		this.telaPrincipal = new TelaPrincipal(sharedDriver.getDriver());
		this.telaCadastro = new TelaCadastro(sharedDriver.getDriver());
		this.telaLogin = new TelaLogin(sharedDriver.getDriver());
	}

	@Given("que estou na tela inicial")
	public void que_estou_na_tela_inicial() {
		this.telaPrincipal.validarTelaInicial();
	}

	@When("clico no menu")
	public void eu_clico_no_menu() {
		this.telaPrincipal.clicarNoMenu();
	}

	@Quando("clico no item LOGIN")
	public void clico_em_LOGIN() {
		this.telaPrincipal.clicarNoItemLogin();
	}

	@When("clico em SIGN UP TODAY")
	public void clico_em_SIGN_UP_TODAY() {
		this.telaLogin.clicarEmSignUpToday();
	}

	@When("na tela de cadastro digito nome de usuario {string} e senha {string}")
	public void digito_no_campo_USER_NAME(String nomeUsuario, String senha) {
		this.telaCadastro.digitarNomeUsuario(nomeUsuario);
		this.telaCadastro.digitarSenha(senha);
	}

	@When("digito {string} no campo EMAIL")
	public void digito_no_campo_EMAIL(String string) {
		this.telaCadastro.digitarEmail(string);
	}

	@When("digito {string} no campo CONFIRM PASSWORD")
	public void digito_no_campo_CONFIRM_PASSWORD(String string) {
		this.telaCadastro.digitarSenhaNovamente(string);
	}

	@When("digito {string} no campo FIRST NAME")
	public void digito_no_campo_FIRST_NAME(String string) {
		this.telaCadastro.digitarPrimeiroNome(string);
	}

	@When("digito {string} no campo LAST NAME")
	public void digito_no_campo_LAST_NAME(String string) {
		this.telaCadastro.digitarUltimoNome(string);
	}

	@When("digito {string} no campo PHONE NUMBER")
	public void digito_no_campo_PHONE_NUMBER(String string) {
		this.telaCadastro.digitarNumeroTelefone(string);
	}

	@When("escolho {string} na lista COUNTRY")
	public void escolho_na_lista_COUNTRY(String string) {
		// this.telaCadastro.selecionarPais(string);
	}

	@When("digito {string} no campo STATE")
	public void digito_no_campo_STATE(String string) {
		this.telaCadastro.digitarEstado(string);
	}

	@When("digito {string} no campo ADDRESS")
	public void digito_no_campo_ADDRESS(String string) {
		this.telaCadastro.digitarEndereco(string);
	}

	@When("digito {string} no campo CITY")
	public void digito_no_campo_CITY(String string) {
		this.telaCadastro.digitarCidade(string);
	}

	@When("digito {string} no campo ZIP")
	public void digito_no_campo_ZIP(String string) {
		this.telaCadastro.digitarCEP(string);
	}

	@And("clico em REGISTER")
	public void clico_em_REGISTER() {
		this.telaCadastro.clicarEmRegistrar();
	}
}
