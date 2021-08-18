package com.graphQL.test;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

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
                .assertThat().statusCode(200)
                .and().body("data.allFilms.films[0].title",equalTo("A New Hope"));
    }
    @Test
    public void getAllUsers(){
        RestAssured.baseURI="https://hasura.io";
        String query = "{\"query\":\"{\\n  users(limit: 10) {\\n    id\\n    name\\n  }\\n}\\n\",\"variables\":null}";
        given().log().all()
                .contentType("application/json")
                .header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYwZDQ4Mjg2OWI4NmIxMDA2ODNiMWFhYyJ9LCJuaWNrbmFtZSI6Im1vbmlsbmlnZGkiLCJuYW1lIjoibW9uaWxuaWdkaUBnbWFpbC5jb20iLCJwaWN0dXJlIjoiaHR0cHM6Ly9zLmdyYXZhdGFyLmNvbS9hdmF0YXIvMzZkMWQ0MzY4ODNmODYwMjUzYTUyNTA2ZmVkODZhNmE_cz00ODAmcj1wZyZkPWh0dHBzJTNBJTJGJTJGY2RuLmF1dGgwLmNvbSUyRmF2YXRhcnMlMkZtby5wbmciLCJ1cGRhdGVkX2F0IjoiMjAyMS0wOC0xOFQxMDowNDozNC43NzdaIiwiaXNzIjoiaHR0cHM6Ly9ncmFwaHFsLXR1dG9yaWFscy5hdXRoMC5jb20vIiwic3ViIjoiYXV0aDB8NjBkNDgyODY5Yjg2YjEwMDY4M2IxYWFjIiwiYXVkIjoiUDM4cW5GbzFsRkFRSnJ6a3VuLS13RXpxbGpWTkdjV1ciLCJpYXQiOjE2MjkyODEwNzcsImV4cCI6MTYyOTMxNzA3NywiYXRfaGFzaCI6ImV2YTNuY1NyNVd1VFB1aE5NaklrUmciLCJub25jZSI6IlVkaWtQRmkyM1lDLTRTc2J5ak1WMXplNWVfNnRnZWFtIn0.BUkot-ackqdGjYuq1MYIXbXTk70yU0yPjv3i7kUJqevb9dKw8dyl3406tDNHUe5xE1uNXJYvN8cnf2ftq1aoMRXAhhdH0XiRV_vFMazHGDwK1fsCwoUwPo49jQNAuRnUBNBYCmdq5UEyZgblPligl_ooaY_P0GbsHO8cDHtAROuTP-YuucMQvd-EmZg5rplw4SSyW5Eo0q5wXmarLYfQDskingIPkDkb-CKU9LRNGLGm7aiUR48qEFZbFKe7WqbAVVe__6TkXyjl5pLVh_9yFrO6tQTizCI1SfOJfAOxpYuZDJAbBKjpyUS0ze9PWYMq32anAgcTdJY4zWD_IYIeFQ")
                .body(query)
                .when().log().all()
                .post("/learn/graphql")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("data.users[0].name",equalTo("tui.glen"));
    }
}
