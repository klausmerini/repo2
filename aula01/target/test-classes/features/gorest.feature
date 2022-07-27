
@Gorest @regressivo
Feature: Criar e editar contas do usuário
  Eu como administrador do sistema, quero cadastrar, editar e excluir usuarios do sistema

  @post
  Scenario: Cadastrar novo usuário API Gorest
    Given Que possuo gorest token valido
    When envio um request de cadastro de usuario com dados validos
    Then o usuario deve sr criado corretamente
    And o status code do request deve ser 201

  @get
  Scenario: Buscar um usuario cadastrado na API GoRest
    Given Que possuo gorest token valido
    And existe o usuario cadastrado na API
    When buscar esse usuario
    Then os dados do usuario devem ser retornados
    And o status code do request deve ser 200


  @put
  Scenario: Altera um usuario existente na API GoRest PUT
    Given Que possuo gorest token valido
    And existe o usuario cadastrado na API
    When altero os dados do usuario
    Then o usuario deve ser alterado com sucesso
    And o status code do request deve ser 200


  @patch
  Scenario: Altera um usuario existente na API GoRest PATCH
    Given Que possuo gorest token valido
    And existe o usuario cadastrado na API
    When altero um ou mais dados do usuario
    Then o usuario deve ser alterado com sucesso
    And o status code do request deve ser 200


  @delete
  Scenario: Deletar um usuario cadastrado na API GoRest
    Given Que possuo gorest token valido
    And existe o usuario cadastrado na API
    When deleto esse usuario
    Then o usuario e deletado corretamente
    And o status code do request deve ser 204