package steps;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class GetInfectedSteps
{
    private RequestSpecification request;
    private ValidatableResponse response;

    @Before
    public void before()
    {
        request = RestAssured.with();
    }

    @Given("I perform GET operation to my Test environment")
    public void iPerformGETOperationToMyTestEnvironment()
    {
        request = given()
                .contentType(ContentType.JSON);
    }

    @When("I perform GET request to {string}")
    public void iPerformGETRequestTo(String path)
    {
        response = request.get("https://my-json-server.typicode.com/adrianszczesny0/rest/Infected/1").then();
    }

    @Then("I should get resposne with status code  of {int}")
    public void iShouldGetResposneWithStatusCodeOf(int code)
    {
        response.statusCode(code);
    }

    @And("I get a response contains country  {string}")
    public void iGetAResponseContainsCountry(String country)
    {
        response.body("country",is(country));
    }
}
