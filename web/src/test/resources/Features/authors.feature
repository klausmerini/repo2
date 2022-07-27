@autor @regressivofakerest
Feature: Criar, editar e deletar autores


 @postAutor
  Scenario:Cadastrar novo autor na API Fakerest
    When   Envio um request de cadastro de autor com dados validos
    Then   o autor deve ser criado corretamente
    And    o status code do request deve ser 200

  @getAutor
  Scenario: Buscar um autor cadastrado na API FakeRest
    Given existe o autor cadastrado na API
    When  buscar esse autor
    Then  os dados do autor devem ser retornados corretamente
    And   o status code do request deve ser 200


  @putAutor
  Scenario:Alterar autor na API Fakerest
    When Envio um request de alteração de autor com dados validos
    Then o autor deve ser alterado corretamente
    And  o status code do request deve ser 200


  @deleteAutor
  Scenario:Deletar autor na API Fakerest
    When Envio um request  para deletar um autor com dados validos
    Then o autor deve ser deletado corretamente
    And  o status code do request deve ser 200
