# language: pt

Funcionalidade: Reserva
  Como um usuário
  Eu quero fazer uma reserva em um restaurante
  Para que eu possa garantir um lugar para comer

  Esquema do Cenario: Registrar Reserva
    Dado informado os seguintes dados da reserva:
      | nome_reserva   | email   | telefone_celular   | horario   | pessoas   | restaurante   | status_reserva   |
      | <nome_reserva> | <email> | <telefone_celular> | <horario> | <pessoas> | <restaurante> | <status_reserva> |
    Quando o usuário solicitar a reserva
    Então o registro da reserva deve ser <resultado_esperado>

    Exemplos:
      | nome_reserva   | email              | telefone_celular | horario             | pessoas | restaurante                          | status_reserva | resultado_esperado |
      | Jorge Valdivia | valdivia@gmail.com | 123456789        | 2024-03-23T08:00:00 | 10      | 6ed285bb-f2f6-4bfa-a1bf-837ebd8019f5 | PENDING        | com sucesso        |
      | Jorge Valdivia | valdivia@gmail.com | 123456789        | 2024-03-23T08:00:00 | 10      | 6ed285bb-f2f6-4bfa-a1bf-837ebd8019f5 | CONFIRMED      | com sucesso        |
      | Jorge Valdivia | valdivia@gmail.com | 123456789        | 2024-03-23T08:00:00 | 10      | 6ed285bb-f2f6-4bfa-a1bf-837ebd8019f5 | RELEASED       | sem sucesso        |
      | Jorge Valdivia | valdivia@gmail.com | 123456789        | 2024-03-23T08:00:00 | 10      | 6ed285bb-f2f6-4bfa-a1bf-837ebd8019f5 | CANCELED       | sem sucesso        |

  @ignore
  Esquema do Cenario: Atualizar Reserva
    Dado informado os seguintes dados da reserva
      | reserva   | status   |
      | <reserva> | <status> |

    Exemplos:
      | reserva | status    |
      | 1       | CONFIRMED |
      | 2       | RELEASED  |
      | 3       | CANCELED  |
