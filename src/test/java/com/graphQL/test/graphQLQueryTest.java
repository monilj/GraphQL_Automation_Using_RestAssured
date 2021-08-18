package com.graphQL.test;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class graphQLQueryTest {
    @Test
    public void getAllFilms(){
        RestAssured.baseURI ="https://swapi-graphql.netlify.app";
        String query = "{\"query\":\"{\\n  allFilms{\\n    films{\\n      title\\n    }\\n  }\\n}\",\"variables\":null}";
        given().log().all()
                .contentType("application/json")
                .body(query)
                .when().log().all()
                .post("/.netlify/functions/index").
                then().log().all()
                .assertThat().statusCode(200);



    }
}
