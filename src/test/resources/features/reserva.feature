# language: pt

Funcionalidade: Registrar Reserva
  Como um usuário
  Eu quero fazer uma reserva em um restaurante
  Para que eu possa garantir um lugar para comer

  Esquema do Cenario: Registro de Reserva
    Dado informado os seguintes dados da reserva:
      | nome_reserva   | email   | telefone_celular   | horario   | pessoas   | restaurante   | status_reserva   |
      | <nome_reserva> | <email> | <telefone_celular> | <horario> | <pessoas> | <restaurante> | <status_reserva> |
    Quando o usuário solicitar o registro do restaurante
    Então o registro do restaurante deve ser <resultado_esperado>

    Exemplos:
      | nome_reserva   | email              | telefone_celular | horario             | pessoas | restaurante         | status_reserva | resultado_esperado |
      | Jorge Valdivia | valdivia@gmail.com | 123456789        | 2024-03-23T08:00:00 | 10      | Outback Steak House | PENDING        | com sucesso        |