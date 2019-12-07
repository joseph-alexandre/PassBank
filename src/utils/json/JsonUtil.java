package utils.json;

import java.io.BufferedReader;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JsonUtil {
	
	private static Gson gson = new Gson();
	private static GsonBuilder builder = new GsonBuilder();
	
	public static String convertToJson(final Object objeto) {
		return gson.toJson(objeto);
	}
	
	public static Object convertJsonToObject(final String json, Object object) {
		return gson.fromJson(json, object.getClass());
	}
	
	
	public static String convertToJson(final List<Object> objects) {
		return gson.toJson(objects);
	}
	
	public static String readJsonFromRequest(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      json.append(line);
		  } catch (Exception e) { 
			  System.out.println("You got a error");
		  }
		  
		  return json.toString();
	}
	
	public static <T> Gson registerAdapter(T object, Object adapter) {
		builder.registerTypeAdapter(object.getClass(), adapter); 
		gson = builder.create();
		return gson;
	}
}
