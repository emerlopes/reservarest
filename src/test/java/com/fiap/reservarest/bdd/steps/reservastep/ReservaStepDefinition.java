package com.fiap.reservarest.bdd.steps.reservastep;

import com.fiap.reservarest.adapter.reservation.mapper.ReservationMapper;
import com.fiap.reservarest.application.entrypoint.rest.reservation.dto.ReservationRequestDTO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class ReservaStepDefinition {

    private ReservationRequestDTO reservationRequest;
    private Response response;
    private static final String HOST = "http://localhost:8080/reservations";


    @Dado("informado os seguintes dados da reserva:")
    public void informado_os_seguintes_dados_do_restaurante(DataTable dataTable) {

        final var dadosInformados = dataTable.asMaps().get(0);

        reservationRequest = ReservationMapper.toRequestDTO(
                dadosInformados.get("nome_reserva"),
                dadosInformados.get("email"),
                dadosInformados.get("telefone_celular"),
                LocalDateTime.parse(dadosInformados.get("horario")),
                Integer.valueOf(dadosInformados.get("pessoas")),
                UUID.fromString(dadosInformados.get("restaurante")),
                dadosInformados.get("status_reserva")
        );
    }

    @Quando("o usuário solicitar a reserva")
    public void o_usuário_solicitar_a_reserva() {
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(reservationRequest)
                .when()
                .post(HOST);
    }

    @Então("o registro da reserva deve ser com sucesso")
    public void o_registro_da_reserva_deve_ser_com_sucesso() {
        System.out.println(reservationRequest);
        response.then().statusCode(201);
//        return response.then().extract().as(CustomResponseRestaurantDTO.class);
    }

    @Então("o registro da reserva deve ser sem sucesso")
    public void o_registro_da_reserva_deve_ser_sem_sucesso() {
        System.out.println(reservationRequest);
        response.then().statusCode(400);
    }
}
