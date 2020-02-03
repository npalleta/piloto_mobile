Feature: Cadastro na aplicação Advantage Shop

  @CT01_Cadastro_Conta
  Scenario Outline: Fazer cadastro
    Given que estou na tela inicial
    When clico no menu
    And clico no item LOGIN
    And clico em SIGN UP TODAY
    And na tela de cadastro digito nome de usuario "<USER>" e senha "<PASSWORD>"
    And digito "<EMAIL>" no campo EMAIL
    And digito "<CONFIRM_PASSWORD>" no campo CONFIRM PASSWORD
    And digito "<FIRST_NAME>" no campo FIRST NAME
    And digito "<LAST_NAME>" no campo LAST NAME
    And digito "<PHONE_NUMBER>" no campo PHONE NUMBER
    And escolho "<COUNTRY>" na lista COUNTRY
    And digito "<STATE>" no campo STATE
    And digito "<ADDRESS>" no campo ADDRESS
    And digito "<CITY>" no campo CITY
    And digito "<ZIP>" no campo ZIP
    And clico em REGISTER
    Then valido se o usuário "<USER>" com o nome "<USER_NAME>" está logado

    Examples: 
      | USER        | USER_NAME       | EMAIL             | PASSWORD | CONFIRM_PASSWORD | FIRST_NAME | LAST_NAME   | PHONE_NUMBER | COUNTRY | STATE     | ADDRESS | CITY                      | ZIP      |
      | rsi_inf_180 | Informatica Rsi | rsi@rsinet.com.br | Rsi12345 | Rsi12345         | Rsi        | Informatica |   1122223333 | BRAZIL  | Sao Paulo | Osasco  | Av. dos Autonomistas, 197 | 06020000 |
