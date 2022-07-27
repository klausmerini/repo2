# Author:Marcelo Ribelato
# Version:1.0

@Correios @regressivo
Feature: : Calcular o valor do frete
  Afim de calcular o valor do frete eu como usuario da API dos correis envio request com dados de origem
  e caracteristicos para saber o valor total do frete e o tempo de entrega

  @frete
  Scenario: calculando o valor do frete com dados validos
    Given que possuo um token valido
    When envio um request com dados validos
    Then o valor do frete deve ser calculado
    And o status code deve ser 200


  @freteDataTable
  Scenario: calculando o valor do frete com dados validos
    Given que possuo um token valido
    When envio um request com dados validos DataTable
      | sCepOrigem | sCepDestino | nVlPeso | nVlComprimento | nVlAltura | nVlLargura |
      | 74371520   | 1327000     | 3.00    | 40.00          | 20.00     | 25         |
    Then o valor do frete deve ser "40,60"
    And o status code deve ser 200


  @freteEsquemaDeCenario
  Scenario: calculando o valor do frete com dados validos esquema de cenario
    Given que possuo um token valido
    When envio um request com dados "<sCepOrigem>","<sCepDestino>"
    Then o valor do frete deve ser "<valorFrete>"
    And o status code deve ser 200

    Examples:
      | sCepOrigem | sCepDestino | valorFrete |
      | 74371520   | 1327000     | 31,00      |
      | 13175613   | 74371520    | 24,80      |


  @freteEsquemaCenario
  Scenario Template: calculando o valor do frete com dados invalidos
    Given que possuo um token valido
    When envio um request com dados "<sCepOrigem>","<sCepDestino>"
    Then deve ser exibida a "<msg>"
    And o status code deve ser 200

    @freteEsquemaCenarioOrigem
    Examples:
      | sCepOrigem | sCepDestino | msg                                                                                                    |
      | 1317561X   | 74371520    | Não foi encontrada precificação. MSG-101: O valor do(s) parâmetro(s) cepOrigem é(são) inválido(s)(-1). |

    @freteEsquemaCenarioDestino
    Examples:
      | sCepOrigem | sCepDestino | msg                                                                                                     |
      | 13175613   | 7437152X    | Não foi encontrada precificação. MSG-101: O valor do(s) parâmetro(s) cepDestino é(são) inválido(s)(-1). |