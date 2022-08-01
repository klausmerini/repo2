@usuarios @regressivofakerest


Feature: Criar, editar e deletar usuarios


  @postUsuarios
  Scenario:Cadastrar novo usuario na API Fakerest
    When   Envio um request de cadastro de usuario com dados validos
    Then   o usuario deve ser criado corretamente
    And    o status code do request deve ser 200

  @getUsuarios
  Scenario: Buscar um usuario cadastrado na API FakeRest
    Given existe o usuario cadastrado na API
    When  buscar esse usuario
    Then  os dados do usuario devem ser retornados corretamente
    And   o status code do request deve ser 200

  @deleteUsuario

  Scenario:Deletar usuario na API Fakerest
    When Envio um request  para deletar um usuario com dados validos
    Then o usuario deve ser deletado corretamente
    And  o status code do request deve ser 200



  @putUsuario
  Scenario:Alterar usuario na API Fakerest
    When Envio um request de alteração de usuario com dados validos
    Then o usuario deve ser alterado corretamente
    And  o status code do request deve ser 200