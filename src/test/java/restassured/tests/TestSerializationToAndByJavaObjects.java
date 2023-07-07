package restassured.tests;

import org.junit.Assert;
import org.junit.Test;
import test.objects.Location;

import static io.restassured.RestAssured.*;

public class TestSerializationToAndByJavaObjects {

    @Test
    public void requestZipCode01000000_checkPlaceNameInResponseBody_expectSaoPaulo(){
        Location location =

        when().
            get("http://api.zippopotam.us/BR/01000-000").
        as(Location.class);

        Assert.assertEquals(
                "São Paulo",
                location.getPlaces().get(0).getPlaceName()
        );
    }

    /*
        It is also possible to send Java Objects as JSON using rest-assured, as the example bellow.
        (it is not runnable because I don't have an API that accept POST Method with this specific content)

        @Test
        public void sendBrZipCode01000000_checkStatusCode_expect200(){
            Location location = new Location();

            given().
                contentType(ContentType.JSON).
                body(location).
                log().body().
            when().
                post("api.url").
            then().
                assertThat().
                statusCode(200);
        }

        In this case, if the API accepts this specific format of json, this test will log the serialized java object
        to json and then send to the API via post, after it, will check if the status code returned is 200.
     */

}
