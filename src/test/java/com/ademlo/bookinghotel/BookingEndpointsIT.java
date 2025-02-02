package com.ademlo.bookinghotel;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookingEndpointsIT {

    @LocalServerPort
    int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void bookingRoomReturnsConfirmation() {
        String requestBody = "{" +
                " \"employeeId\": \"123\", " +
                " \"roomId\": \"101\", " +
                " \"startDate\": \"2023-04-05\", " +
                " \"endDate\": \"2023-04-15\" " +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .body("bookingId", notNullValue())
                .body("message", equalTo("Reservation confirmed"));
    }

    @Test
    void bookingReturnsDetail() {
        String requestBody = "{" +
                " \"employeeId\": \"123\", " +
                " \"roomId\": \"101\", " +
                " \"startDate\": \"2023-04-05T00:00:00.000+00:00\", " +
                " \"endDate\": \"2023-04-15T00:00:00.000+00:00\" " +
                "}";

        String bookingId = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .body("bookingId", notNullValue())
                .extract()
                .path("bookingId");

        given()
                .contentType(ContentType.JSON)
                .pathParams("bookingId", bookingId)
                .when()
                .get("/booking/{bookingId}")
                .then()
                .statusCode(200)
                .body("employeeId", equalTo(123))
                .body("roomId", equalTo(101))
                .body("startDate", equalTo("2023-04-05T00:00:00.000+00:00"))
                .body("endDate", equalTo("2023-04-15T00:00:00.000+00:00"));
    }

    @Test
    void getNonExistsBookingIdReturnNotFound() {
        String nonExistsBookingId = "non-exist-id";

        given().pathParams("bookingId", nonExistsBookingId).when()
                .get("/booking/{bookingId}")
                .then()
                .statusCode(404);
    }
}
