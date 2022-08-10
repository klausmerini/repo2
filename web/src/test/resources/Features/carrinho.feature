#language: pt
#Author: Klaus Merini
#Version: 1.0
#Encoding: UTF-8

@web @compras
Funcionalidade: Comprar livro

  @compralivro
  Cenario: Selecionar livro no carrinho de compras
    Dado que estou no site demowebshop
    E clico em books
    Entao seleciono um livro
    Entao site adiciona o livro ao carrinho de compras


  @compravarios
  Cenario: Comprar de todos menus
    Dado que estou no site demowebshop
    E clico em cada menu selecionando um produto de cada menu
    Entao site adiciona os produtos ao carrinho de compras


  @compratudo
  Cenario: Comprar todos itens de todos menus
    Dado que estou no site demowebshop
    E clico em cada menu selecionando todos produtos de cada menu
    Entao site adiciona os produtos (todos) ao carrinho de compras




