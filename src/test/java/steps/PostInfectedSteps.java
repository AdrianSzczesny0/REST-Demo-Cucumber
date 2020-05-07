package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
public class PostInfectedSteps
{

    public static JSONObject json = new JSONObject();
    private RequestSpecification request;
    private Response resp;

    @Given("I perform POST operation to my Test environment")
    public void iPerformPOSTOperationToMyTestEnvironment() throws Throwable
    {
        request = given()
                .contentType("application/json; charset=utf-8");
    }


    @And("I set my POST body to {string} and its value to {int} and id to {int}")
    public void iSetMyPOSTBodyToAndItsValueToAndIdTo(String country, int infectedCount, int id) throws  Throwable
    {
        json.put("id",id);
        json.put("country",country);
        json.put("count",infectedCount);
        request.body(json.toJSONString());
    }

    @When("I perform POST request to {string}")
    public void iPerformPOSTRequestTo(String url)  throws Throwable
    {
        resp = request.post(url);
        resp.prettyPrint();
    }

    @Then("I should get response with code {int}")
    public void iShouldGetResponseWithCode(int code) throws Throwable
    {
        resp.then().assertThat()
                .statusCode(code);
    }

    @And("I should get response with body containing {string}")
    public void iShouldGetResponseWithBodyContaining(String country)throws Throwable
    {
        resp.then().and()
                .body("country",equalTo(country));
    }
}
