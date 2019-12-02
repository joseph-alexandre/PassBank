package utils;

import com.google.gson.Gson;

public class JsonUtil {
	
	private static Gson gson = new Gson();
	
	public static String convertToJson(final Object objeto) {
		return gson.toJson(objeto);
	}
	
	public static Object convertJsonToObject(final String json, Object object) {
		return gson.fromJson(json, object.getClass());
	}
	
}
