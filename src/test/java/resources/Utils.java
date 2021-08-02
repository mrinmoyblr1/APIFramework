package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {
		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("looging.txt"));

			req = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl")).addQueryParam("Key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}

	
	
	
	public static String getGlobalValues(String Key) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Mrinmoy\\eclipse-workspace-2\\APIFramework\\src\\test\\java\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(Key);

	}
	
	
	public String getJsonPath(Response response, String Key)
	{
		
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(Key).toString();
		
		

	}
	

}
