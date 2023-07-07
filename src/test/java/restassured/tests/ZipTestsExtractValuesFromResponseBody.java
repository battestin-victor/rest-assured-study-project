package restassured.tests;

import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class ZipTestsExtractValuesFromResponseBody {

    @Test
    public void requestBrZipCode01000000_extractPlaceNameFromResponseBody_assertEqualsSaoPaulo() {
        String placeName =

        when().
            get("http://api.zippopotam.us/BR/01000-000").
        then().
            extract().
            path("places[0].'place name'");

        Assert.assertEquals(placeName, "São Paulo");
    }
}
