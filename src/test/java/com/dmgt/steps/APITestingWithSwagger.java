package com.dmgt.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITestingWithSwagger {

   // @Test(priority=1,dataProvider="Data")
    @Given("user add pet to the store")
    public void user_add_pet_to_the_store(String id,String category,String name,String photoUrls, String tags,String status) {

        HashMap data=new HashMap();

        data.put("id",id);
        data.put("category", category);
        data.put("name", name);
        data.put("photoUrls", photoUrls);
        data.put("tags", tags);
        data.put("status", status);

            Response res=
                    given()
                            .contentType("application/json")
                            .body(data)
                            .when()
                            .post("http://petstore.swagger.io/v2/pet")
                            .then()
                            .statusCode(200)
                            .log().body()
                            .extract().response();

            String jsonString=res.asString();
            Assert.assertEquals(jsonString.contains("Record Added Successfully"), true);

        }


    @When("user should see the result in server")
    public void user_should_see_the_result_in_server() {

        HashMap data=new HashMap();

        data.put("id",10);
        data.put("category", 2);
        data.put("name", "cat");
        data.put("photoUrls", "string");
        data.put("tags", 4);
        data.put("status", "available");


            Response res=
                    given()
                            .contentType("application/json")
                            .body(data)
                            .when()
                            .post("http://petstore.swagger.io/v2/pet")

                            .then()
                            .statusCode(200)
                            .log().body()
                            .extract().response();

            String jsonString=res.asString();
            Assert.assertEquals(jsonString.contains("Record Added Successfully"), true);

        }



    //@Test(priority=2,dataProvider="Data")
    @Given("user find the pet by id")
    public void user_find_the_pet_by_id(String id,String category,String name,String photoUrls, String tags,String status) {
       /* @Test(priority=2,dataProvider="Data")
        public void test_getVideoGame(String id,String name)
        {*/
            given()
                    .pathParam("id",id)
                    .when()
                    .get("http://petstore.swagger.io/v2/pet/{petId}")
                    .then()
                    .statusCode(200)
                    .log().body()
                    .body("pet.id", equalTo(id))
                    .body("pet.name", equalTo(name));

        }


        @When("user should get pet id result")
        public void userShouldGetPetIdResult() {
            given()
                    .when()
                    .get("http://petstore.swagger.io/v2/pet/10")
                    .then()
                    .statusCode(200)
                    .log().body()
                    .body("pet.id", equalTo("10"))
                    .body("pet.name", equalTo("cat"));

        }



}



