#language: pt
Funcionalidade: Login na aplicação Advantage Shop

  @CT02_Login_Conta
  Esquema do Cenário: Fazer login
    Dado que estou na tela inicial
    Quando clico no menu
    E clico no item LOGIN
    E na tela de login digito nome de usuario "<USER>" e senha "<PASSWORD>"
    E clico no botão LOGIN
    Entao valido se o usuário "<USER>" com o nome "<USER_NAME>" está logado

    Exemplos: 
      | USER    | PASSWORD | USER_NAME       |
      | rsi_inf | Rsi12345 | Informatica Rsi |
