#language: pt
#Author: Rafael Lima
#Version: 1.0
#Encoding: UTF-8


Funcionalidade: Comprar livro


  Cenario: Selecionar livro no carrinho de compras
    Dado que estou no site demowebshop
    E clico em books
    Entao seleciono um livro
    Entao site adiciona o livro ao carrnho e compras



    Cenario: Registrar usuario
      Dado que estou no site demowebshop
      E clico em register
      Entao preencho os campos corretamente
      Entao site inclui usuario com sucesso


      Cenario: Logar usuario
        Dado que estou no site demowebshop
        E clico em login
        Entao preencho os campos de login corretamente
        Entao site loga usuario com sucesso


        Cenario: Comprar de todos menus
          Dado que estou no site demowebshop
          E clico em cada menu selecionando um produto de cada menu
          Entao site adiciona os produtos ao carrinho e compras



  Cenario: Comprar de todos menus
    Dado que estou no site demowebshop
    E clico em cada menu selecionando todos produtos de cada menu
    Entao site adiciona os produtos ao carrinho e compras



          Cenario: Usuario assina newletter
            Dado que estou no site demowebshop
            Entao preencho o campo 'Sign up for our newsletter'
            E clico em Subscribe
            Entao site exibe mensagem confirmando inscrição


  Cenario: Usuario faz busca
    Dado que estou no site demowebshop
    Entao preencho o campo Search com valor valido
    E clico em Search
    Entao site exibe lista de opções
    Entao usuario seleciona um camcorder


