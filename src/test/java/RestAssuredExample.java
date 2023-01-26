
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.IAssert;
import static io.restassured.RestAssured.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import static org.hamcrest.Matchers.*;
public class RestAssuredExample {
    @Test
    void GetExample() {
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
                then().statusCode(200).
                body("data[4].first_name", equalTo("George")).
                body("data.first_name", hasItems("George", "Rachel"));
    }
    @Test
    void PostExample(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("Name","Aman");
        map.put("job","QA");
        System.out.println(map);
    }
@Test
    void GetExample1 (){
        baseURI="https://reqres.in/api/users/2";
        given().queryParam("page,2")
                .body("").when()
                .get().then()
                .assertThat().statusCode(200)
                .body("page",equalTo(3));
    }
    @Test
    void  PostExample1() {
        baseURI="https://reqres.in/api/users";
        String userData =
                "{" +
                "\"name\" : \"Amanda\"," +
                "\"Job\" : \"QA\"," +

                "}";
        given().body(userData)
                .when().post()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201)
                .body("id", is(notNullValue()));
    }
    @Test
    void patchExample(){
        baseURI="https://reqres.in/api/users/2";
        String userData =
                "{" +
                        "\"email\" : \"Amanda@gmail.com\"," +
                        "\"Job\" : \"QA\"," +

                        "}";
        given().body(userData)
                .when()
                .patch()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201)
                .body("id", is(notNullValue()));
    }
    @Test
    void PutExample(){
        baseURI="https://reqres.in/api/users/2";
        String userData =
                "{" +
                        "\"name\" : \"AmandaJ\"," +
                        "\"Job\" : \"QA\"," +

                        "}";
        given().body(userData)
                .when()
                .put()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201)
                .body("id", is(notNullValue()));
    }


    }


