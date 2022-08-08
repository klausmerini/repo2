#language: pt
#Author: Klaus Merini
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

  @compravarios
  Cenario: Comprar de todos menus
    Dado que estou no site demowebshop
    E clico em cada menu selecionando um produto de cada menu
    Entao site adiciona os produtos ao carrinho de compras


  @compratudo
  Cenario: Comprar de todos menus
    Dado que estou no site demowebshop
    E clico em cada menu selecionando todos produtos de cada menu
    Entao site adiciona os produtos (todos) ao carrinho de compras


  @newsletter
  Cenario: Usuario assina newletter
    Dado que estou no site demowebshop
    Entao preencho o campo 'Sign up for our newsletter'
    E clico em Subscribe
    Entao site exibe mensagem confirmando inscrição

  @search
  Cenario: Usuario faz busca
    Dado que estou no site demowebshop
    Entao preencho o campo Search com valor valido
    E clico em Search
    Entao site exibe lista de opções
    Entao usuario seleciona um camcorder


