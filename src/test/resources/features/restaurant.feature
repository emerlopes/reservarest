# language: pt

Funcionalidade: Restaurante
  Como um usuário
  Eu quero registrar um restaurante
  Para que ele possa receber reservas e avaliações

  Esquema do Cenario: Resgistrar restaurante
    Dado informado os seguintes dados do restaurante:
      | nome   | localizacao   | tipo_cozinha   | horario_funcionamento   | quantidade_mesas   |
      | <nome> | <localizacao> | <tipo_cozinha> | <horario_funcionamento> | <quantidade_mesas> |
    Quando o usuário solicitar o registro do restaurante
    Então o registro do restaurante deve ser <resultado_esperado>

    Exemplos:
      | nome                 | localizacao | tipo_cozinha | horario_funcionamento | quantidade_mesas | resultado_esperado |
      | Outback Steake House | Centro      | Steake House | 8                     | 10               | com sucesso        |
      |                      | Centro      | Steake House | 8                     | 10               | sem sucesso        |
      | Outback Steake House |             | Steake House | 8                     | 10               | sem sucesso        |
      | Outback Steake House | Centro      |              | 8                     | 10               | sem sucesso        |