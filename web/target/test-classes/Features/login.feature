#language: pt
#Author: Rafael Lima
#Version: 1.0
#Encoding: UTF-8

  @funcionalidades
Funcionalidade: Comprar livro

  @compralivro
  Cenario: Selecionar livro no carrinho de compras
    Dado que estou no site demowebshop
    E clico em books
    Entao seleciono um livro
    Entao site adiciona o livro ao carrnho e compras


    @registra
    Cenario: Registrar usuario
      Dado que estou no site demowebshop
      E clico em register
      Entao preencho os campos corretamente
      Entao site inclui usuario com sucesso

      @login
      Cenario: Logar usuario
        Dado que estou no site demowebshop
        E clico em login
        Entao preencho os campos de login corretamente
        Entao site loga usuario com sucesso

        @compratudo
        Cenario: Comprar de todos menus
          Dado que estou no site demowebshop
          E clico em cada menu
          Entao seleciono um produto de cada menu
          Entao site adiciona os produtos ao carrnho e compras
