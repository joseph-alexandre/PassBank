package utils.json.adapters;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import model.Platform;

public class PlatformAdapter extends TypeAdapter<Platform> {
	
	  @Override 
	   public Platform read(JsonReader reader) throws IOException { 
	      Platform platform = new Platform(); 
	      reader.beginObject(); 
	      String fieldname = null; 
	      
	      while (reader.hasNext()) { 
	         JsonToken token = reader.peek();            
	         
	         if (token.equals(JsonToken.NAME)) {      
	            fieldname = reader.nextName(); 
	         } 
	         
	         if ("name".equals(fieldname)) {       
	           
	            token = reader.peek(); 
	            platform.setName(reader.nextString()); 
	         } 
	         
	         if("image".equals(fieldname)) { 
	            token = reader.peek(); 
	            platform.setImage(reader.nextString()); 
	         } 
	         
	         if("username".equals(fieldname)) {
	        	 token = reader.peek();
	        	 platform.setUsername(reader.nextString());
	         }
	         
	         if("password".equals(fieldname)) {
	        	 token = reader.peek();
	        	 platform.setPassword(reader.nextString());
	         }
	      } 
	      reader.endObject(); 
	      return platform; 
	   }  
	   
	   @Override 
	   public void write(JsonWriter writer, Platform platform) throws IOException { 
	      writer.beginObject(); 
	      writer.name("name"); 
	      writer.value(platform.getName()); 
	      writer.name("image"); 
	      writer.value(platform.getImage());
	      writer.name("username");
	      writer.value(platform.getUsername());
	      writer.name("password");
	      writer.value(platform.getPassword());
	      writer.endObject(); 
	   } 

}
