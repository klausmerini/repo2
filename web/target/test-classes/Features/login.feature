#language: pt
#Author: Rafael Lima
#Version: 1.0
#Encoding: UTF-8

@logins @web
Funcionalidade: Log in

  @registrausuario
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

    @logout
    Cenario: Deslogar usuario
      Dado que estou no site demowebshop
      E estou logado
      Entao faço o log out
      Entao site desloga usuario com sucesso