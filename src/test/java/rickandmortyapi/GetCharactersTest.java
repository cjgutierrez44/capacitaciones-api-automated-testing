package rickandmortyapi;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetCharactersTest {

    @Test
    public void getPage() {
        RequestSpecification request = given()
                .baseUri("https://rickandmortyapi.com/api")
                .basePath("/character")
                .queryParam("page", "1");

        Response response = request.when().get();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void getSingleCharacter() {
        RequestSpecification request = given()
                .baseUri("https://rickandmortyapi.com/api")
                .basePath("/character");

        Response response = request.when().get("/3");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
    }
}
