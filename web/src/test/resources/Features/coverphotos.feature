@covephotos @regressivofakerest


Feature: Criar, editar e deletar coverphotos


  @postCoverphotos
  Scenario:Cadastrar novo coverphotos na API Fakerest
    When   Envio um request de cadastro de coverphotos com dados validos
    Then   o coverphotos deve ser criado corretamente
    And    o status code do request deve ser 200

  @getCoverphotos
  Scenario: Buscar um coverphotos cadastrado na API FakeRest
    Given existe o coverphotos cadastrado na API
    When  buscar esse coverphotos
    Then  os dados do coverphotos devem ser retornados corretamente
    And   o status code do request deve ser 200

    @deleteCoverphotos

    Scenario:Deletar Coverphotos na API Fakerest
      When Envio um request  para deletar um Coverphotos com dados validos
      Then o Coverphotos deve ser deletado corretamente
      And  o status code do request deve ser 200



  @putCoverphotos
  Scenario:Alterar Coverphotos na API Fakerest
    When Envio um request de alteração de Coverphotos com dados validos
    Then o Coverphotos deve ser alterado corretamente
    And  o status code do request deve ser 200