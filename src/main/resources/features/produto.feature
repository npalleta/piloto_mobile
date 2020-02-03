#language: pt
Funcionalidade: Fazer pesquisa de produtos na loja

  @CT03_Pesquisa_Produto_Filtro_Tela_Principal
  Esquema do Cenario: Faz a pesquisa de um produto a partir da tela principal
    Dado que estou na tela inicial
    Quando eu digito o "<produto>" no campo search
    E clico no botão search
    E seleciono o produto "<produto>"
    Então verifico se a tela do produto "<produto>" é apresentada

    Exemplos: 
      | produto                          |
      | HP CHROMEBOOK 14 G1(ENERGY STAR) |
      | HP PRO TABLET 608 G1             |

  @CT04_Adicionar_Produto_Carrinho
  Esquema do Cenario: Adicionar o produto pesquisado ao carrinho
    Dado que estou na tela inicial
    Quando clico no menu
    E clico no item LOGIN
    E na tela de login digito nome de usuario "<USER>" e senha "<PASSWORD>"
    E clico no botão LOGIN
    Quando eu digito o "<produto>" no campo search
    E clico no botão search
    E seleciono o produto "<produto>"
    E verifico se a tela do produto "<produto>" é apresentada
    E adiciono o produto ao carrinho
    E valido se o produto "<produto>" foi adicionado ao carrinho
    Entao valido se o usuário "<USER>" com o nome "<USER_NAME>" está logado

    Exemplos: 
      | produto                          | USER    | PASSWORD | USER_NAME       |
      | HP CHROMEBOOK 14 G1(ENERGY STAR) | rsi_inf | Rsi12345 | Informatica Rsi |
      | HP PRO TABLET 608 G1             | rsi_inf | Rsi12345 | Informatica Rsi |

  @CT05_Pesquisa_Produto_Categoria_Tela_Principal
  Esquema do Cenario: Pesquisar um produto a partir de uma categoria da tela principal
    Dado que estou na tela inicial
    Quando eu escolho a categoria "<categoria>"
    E seleciono o produto "<produto>"
    Entao verifico se a tela do produto "<produto>" é apresentada

    Exemplos: 
      | categoria  | produto                                        |
      | headphones | BEATS STUDIO 2 OVER-EAR MATTE BLACK HEADPHONES |

  @CT06_Pesquisa_Produto_Categoria_Tela_Principal_Offline
  Esquema do Cenario: Pesquisar um produto a partir de uma categoria da tela principal no modo offline
    Dado que a aplicação está configurada para o servidor "<server>"
    E que estou na tela inicial
    Quando eu escolho a categoria "<categoria>"
    E seleciono o produto "<produto>"
    Entao verifico se a tela do produto "<produto>" é apresentada

    Exemplos: 
      | categoria  | produto                                        | server       |
      | headphones | BEATS STUDIO 2 OVER-EAR MATTE BLACK HEADPHONES | Offline Mode |

  @CT07_Pesquisa_Produto_Filtro_Tela_Principal_Offline
  Esquema do Cenario: Pesquisar um produto a partir de uma categoria da tela principal no modo offline
    Dado que a aplicação está configurada para o servidor "<server>"
    E que estou na tela inicial
    Quando eu digito o "<produto>" no campo search
    E clico no botão search
    E seleciono o produto "<produto>"
    Então verifico se a tela do produto "<produto>" é apresentada

    Exemplos: 
      | categoria  | produto                                        | server       |
      | headphones | BEATS STUDIO 2 OVER-EAR MATTE BLACK HEADPHONES | Offline Mode |
