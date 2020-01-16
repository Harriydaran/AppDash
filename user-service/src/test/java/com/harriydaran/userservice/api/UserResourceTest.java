package com.harriydaran.userservice.api;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserResourceTest {

  @Test public void testUserHasCorrectTown() {

    when().
        get("/api/v1/users/1").
        then().
        statusCode(200).
        body("address.town", equalTo("Ilford"));

  }

}