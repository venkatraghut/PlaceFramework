package resouces;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;


public class Utils {
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException {
		
		if(req==null) {
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		
		return req;
		}
		return req;
	}
	
	public String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream("global.properties");
		prop.load(input);
		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response response, String key) {
		
		String resp = response.asString().trim();
	    if (resp.isEmpty()) {
	        return null; // Or throw a custom message
	    }
	    return new JsonPath(resp).getString(key);
		
//		String resp = response.asString();
//		JsonPath js = new JsonPath(resp);
//		return js.get(key);
	}

}
