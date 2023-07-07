package restassured.tests;

import org.junit.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ZipTestsBasicTestsAndAsserts {

    /*
        Basic test
     */

    @Test
    public void requestBrZipCode01000000_checkStatusCode_expectHttp200(){
        when().
            get("http://api.zippopotam.us/BR/01000-000").
        then().
            assertThat().
            statusCode(200).
            assertThat().
            contentType(ContentType.JSON);
    }

    /*
        Logging information
     */

    @Test
    public void requestBrZipCode01000000_LogRequestAndResponseDetails(){
        given().
            log().all().
        when().
            get("http://api.zippopotam.us/BR/01000-000").
        then().
            log().body();
    }

    /*
        Assertions on response body

        Note that property place name is covered by single quote, this is used because of the space between the words,
        so the json-path can recognize the property name, without the single quote the locator will break because it
        doesn't support spaces in its syntax.
     */
    @Test
    public void requestBrZipCode01000000_checkPlaceNameInResponseBody_expectsSaoPaulo() {
        when().
            get("http://api.zippopotam.us/BR/01000-000").
        then().
            assertThat().
                body("places[0].'place name'", equalTo("São Paulo"));
    }

    @Test
    public void requestBrZipCode01000000_checkStateNameInResponseBody_expectSaoPaulo() {
        when().
            get("http://api.zippopotam.us/BR/01000-000").
        then().
            body("places[0].state",equalTo("Sao Paulo"));
        //note that in this case, there is no need to use single quote, because the selector name is a single word.
    }

    @Test
    public void requestBrZipCode01000000_checkListOfPlacesInResponseBody_expectContainsSaoPaulo() {
        when().
            get("http://api.zippopotam.us/BR/01000-000").
        then().
            body("places.'place name'",contains("São Paulo"));
    }

    @Test
    public void requestBrZipCode20000000_checkListOfPlacesInResponseBody_expectNotContainsSaoPaulo() {
        when().
            get("http://api.zippopotam.us/BR/20000-000").
        then().
            body("places.'place name'",not(contains("São Paulo")));
    }

    @Test
    public void requestBrZipCode01000000_checkNumberOfPlaceNamesInResponseBody_expectOne(){
        when().
            get("http://api.zippopotam.us/BR/01000-000").
        then().
            body("places",hasSize(1));
    }
}
