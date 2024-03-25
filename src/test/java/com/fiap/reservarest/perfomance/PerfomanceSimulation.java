package com.fiap.reservarest.perfomance;

import io.gatling.javaapi.core.ActionBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.OpenInjectionStep.atOnceUsers;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.internal.HttpCheckBuilders.status;

public class PerfomanceSimulation extends Simulation {

    private final HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080")
            .header("Content-Type", "application/json");

    ActionBuilder request = http("Get All Restaurants")
            .post("/restaurants")
            .body(StringBody("{\n" +
                    "\t\"name\": \"Outback Steake House\",\n" +
                    "\t\"location\": \"Granja Vianna\",\n" +
                    "\t\"cuisine_type\": \"Steake House\",\n" +
                    "\t\"hours_of_operation\": 8.5,\n" +
                    "\t\"tables\": 20\n" +
                    "}"))
            .check(status().is(200));

    ScenarioBuilder scenarioRegistrarRestaurante = scenario("Registrar Restaurante")
            .exec(request);

    {
        setUp(scenarioRegistrarRestaurante.injectOpen(atOnceUsers(1000)))
                .protocols(httpProtocol)
                .assertions(global().responseTime().max().lt(1));
    }

}
