



@Fakerest @regressivo
Feature: Criar, editar e deletar atividades

  @postFake
  Scenario:Cadastrar nova atividade na API Fakerest
    When : Envio um request de cadastro de atividades com dados validos
    Then : a atividade deve ser criada corretamente
    And o status code do request deve ser 200

  @getFake
  Scenario: Buscar uma atividade cadastrada na API FakeRest
    Given existe a atividade cadastrada na API
    When buscar essa atividade
    Then os dados da atividade devem ser retornados
    And o status code do request deve ser 200

  @deleteFake
  Scenario: Deletar uma atividade cadastrada na API FakeRest
    Given existe a atividade cadastrada na API
    When deleto essa atividade
    Then a atividade e deletada corretamente
    And o status code do request deve ser 200

  @putFake
  Scenario: Altera uma atividade existente na API FakeRest
    Given existe a atividade cadastrado na API
    When altero os dados da atividade
    Then a atividade deve ser alterada com sucesso
    And o status code do request deve ser 200

