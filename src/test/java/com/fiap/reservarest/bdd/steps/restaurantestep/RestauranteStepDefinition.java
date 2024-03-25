package com.fiap.reservarest.bdd.steps.restaurantestep;

import com.fiap.reservarest.adapter.restaurant.mapper.RestaurantMapper;
import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantRequestDTO;
import com.fiap.reservarest.bdd.dto.CustomResponseRestaurantDTO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;

public class RestauranteStepDefinition {

    private RestaurantRequestDTO restaurantRequest;
    private Response response;
    private static final String HOST = "http://localhost:8080/restaurants";


    @Dado("informado os seguintes dados do restaurante:")
    public void informado_os_seguintes_dados_do_restaurante(DataTable dataTable) {

        final var dadosInformados = dataTable.asMaps().get(0);

        restaurantRequest = RestaurantMapper.toRequestDTO(
                dadosInformados.get("nome"),
                dadosInformados.get("localizacao"),
                dadosInformados.get("tipo_cozinha"),
                Double.valueOf(dadosInformados.get("horario_funcionamento")),
                Integer.valueOf(dadosInformados.get("quantidade_mesas"))
        );
    }

    @Quando("o usuário solicitar o registro do restaurante")
    public void o_usuário_solicitar_o_registro_do_restaurante() {
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(restaurantRequest)
                .when()
                .post(HOST);
    }

    @Então("o registro do restaurante deve ser com sucesso")
    public CustomResponseRestaurantDTO o_registro_do_restaurante_deve_ser_com_sucesso() {
        response.then().statusCode(201);
        return response.then().extract().as(CustomResponseRestaurantDTO.class);
    }

    @Então("o registro do restaurante deve ser sem sucesso")
    public void o_registro_do_restaurante_deve_ser_sem_sucesso() {
        response.then().statusCode(400);
    }

}
