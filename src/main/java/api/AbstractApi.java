package api;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

import constants.ApiConstants;

public class AbstractApi {

	private static RequestSpecification tokenSpec = null;
	public static Map<String, String> extraHeaders = new HashMap<String, String>();

	public static RequestSpecification getSpecWithExtraHeaders() {
		tokenSpec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(ApiConstants.BASE_URI)
				.addHeader("User-Agent-WW", "web_agent").addHeaders(extraHeaders).build();
		return tokenSpec;
	}

	protected <T> T createResource(String path, Object requestBody, Class<T> responseClass) {
		return given().relaxedHTTPSValidation().spec(getSpecWithExtraHeaders()).body(requestBody).when().post(path)
				.then().assertThat().statusCode(anyOf(is(201), is(200), is(302))).extract().as(responseClass);
	}

	protected <T> T updateResource(String path, Object requestBody, Class<T> responseClass) {
		return given().relaxedHTTPSValidation().spec(getSpecWithExtraHeaders()).body(requestBody).when().put(path)
				.then().assertThat().statusCode(anyOf(is(201), is(200), is(302))).extract().as(responseClass);
	}

	protected <T> T getResource(String path, Class<T> responseClass) {
		return given().relaxedHTTPSValidation().spec(getSpecWithExtraHeaders()).when().get(path).then().assertThat()
				.statusCode(anyOf(is(201), is(200), is(302))).extract().as(responseClass);
	}

	protected void deleteResource(String path) {
		given().relaxedHTTPSValidation().spec(getSpecWithExtraHeaders()).when().delete(path).then().assertThat()
				.statusCode(anyOf(is(201), is(204), is(200), is(302))).extract().response().asString();
	}

	protected void uploadResource(String path, String resourcePath) {
		given().relaxedHTTPSValidation().spec(getSpecWithExtraHeaders()).multiPart(new File(resourcePath)).when()
				.post(path).then().assertThat().statusCode(anyOf(is(201), is(204), is(200), is(302)));
	}

}
