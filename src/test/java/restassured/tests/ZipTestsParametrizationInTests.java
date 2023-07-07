package restassured.tests;

import com.tngtech.java.junit.dataprovider.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(DataProviderRunner.class)
public class ZipTestsParametrizationInTests {

    @DataProvider
    public static Object[][] zipCodeAndPlaces(){
        return new Object[][] {
                {"us","90210","Beverly Hills"},
                {"BR","01000-000","São Paulo"},
                {"BR","20000-000","Rio de Janeiro"},
                {"BR","30000-000","Belo Horizonte"}
        };
    }

    @Test
    @UseDataProvider("zipCodeAndPlaces")
    public void requestZipCodesFromDataCollection_checkPlaceNameInResponseBody_expectSpecifiedPlaceNames(String countryCode, String zipCode, String expectedPlaceName) {
        given().
            pathParams("countryCode", countryCode).pathParams("zipCode", zipCode). // It is needed to declare what test method parameters will be used as path parameters in the API call.
        when().
            get("http://api.zippopotam.us/{countryCode}/{zipCode}").
        then().
            assertThat().
            body("places[0].'place name'",equalTo(expectedPlaceName)); // For the assertion, the correct way is to use directly the test method parameters
    }
}
