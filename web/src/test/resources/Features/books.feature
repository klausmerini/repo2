@livro @regressivofakerest
Feature: Criar, editar e deletar livros


  @postLivro
  Scenario:Cadastrar novo livro na API Fakerest
    When   Envio um request de cadastro de livro com dados validos
    Then   o livro deve ser criado corretamente
    And    o status code do request deve ser 200

  @getLivro
  Scenario: Buscar um livro cadastrado na API FakeRest
    Given existe o livro cadastrado na API
    When  buscar esse livro
    Then  os dados do livro devem ser retornados corretamente
    And   o status code do request deve ser 200

    @deleteLivro
    Scenario:Deletar livro na API Fakerest
      When Envio um request  para deletar um livro com dados validos
      Then o livro deve ser deletado corretamente
      And  o status code do request deve ser 200


  @putLivro
  Scenario:Alterar livro na API Fakerest
    When Envio um request de alteração de livro com dados validos
    Then o livro deve ser alterado corretamente
    And  o status code do request deve ser 200

