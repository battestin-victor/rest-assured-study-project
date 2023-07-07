package restassured.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestWorkingWithXMLResponses {

    private static RequestSpecification requestSpec;

    @BeforeClass
    public static void createRequestSpec(){
        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://run.mocky.io/v3").
                build();
    }


    @Test
    public void requestBooksFromAuthor_checkBookNameInResponseBody_expectEnviesados(){
        given().
            spec(requestSpec).
        when().
            get("/990c10d4-35f2-43dd-9a5d-22be757f13bf").
        then().
            assertThat().
            body("author.books.book.title", equalTo("Enviesados"));
    }

    @Test
    public void requestBooksFromAuthorGustavoCerbasi_checkThirdBookPagesInBooksListInResponseBody_expect197(){
        given().
            spec(requestSpec).
        when().
            get("/66a09322-7186-4cd6-aaaf-ec7778348477").
        then().
            assertThat().
            body("author.books.book[2].pages",equalTo("197"));
    }

    @Test
    public void requestBooksFromAuthorGustavoCerbasi_checkLastBoookNameInResponseBody_expectPaisInteligenteEnriquecemSeusFilhos(){
        given().
            spec(requestSpec).
        when().
            get("/66a09322-7186-4cd6-aaaf-ec7778348477").
        then().
            assertThat().
            body("author.books.book[-1].title",equalTo("Pais inteligentes enriquecem seus filhos"));
    }

    @Test
    public void requestBooksFromAuthorGustavoCerbasi_checkBookPublisherNameInResponseBody_expectSextante(){
        given().
            spec(requestSpec).
        when().
            get("/66a09322-7186-4cd6-aaaf-ec7778348477").
        then().
            assertThat().
            body("author.books.book[0].@publisher",equalTo("sextante"));
    }

    @Test
    public void requestBooksFromAuthorGustavoCerbasi_checkNumberOfBooksPublishedBySextante_expect3(){
        given().
            spec(requestSpec).
        when().
            get("/66a09322-7186-4cd6-aaaf-ec7778348477").
        then().
            assertThat().
            body("author.books.book.findAll{it.@publisher=='sextante'}",hasSize(3)); //using xml-path you can also use filters to select specific situations from your response body
    }
}
