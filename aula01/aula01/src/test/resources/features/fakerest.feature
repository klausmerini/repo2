


@Fakerest
  Feature: Criar, editar e deletar atividades

    @post
    Scenario:Cadastrar nova atividade na API Fakerest
      When : Envio um request de cadastro de atividades com dados validos
      Then : a atividade deve ser criada corretamente
      And o status code do request deve ser 201

    @getFake
    Scenario: Buscar uma atividade cadastrada na API FakeRest
      Given existe a atividade cadastrada na API
      When buscar essa atividade
      Then os dados da atividade devem ser retornados
      And o status code do request deve ser 200
