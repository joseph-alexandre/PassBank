package utils.json.adapters;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import model.User;

public class UserAdapter extends TypeAdapter<User> {
	
	  @Override 
	   public User read(JsonReader reader) throws IOException { 
	      User user = new User(); 
	      reader.beginObject(); 
	      String fieldname = null; 
	      
	      while (reader.hasNext()) { 
	         JsonToken token = reader.peek();            
	         
	         if (token.equals(JsonToken.NAME)) {      
	            fieldname = reader.nextName(); 
	         } 
	         
	         if ("name".equals(fieldname)) {       
	           
	            token = reader.peek(); 
	            user.setName(reader.nextString()); 
	         } 
	         
	         if("email".equals(fieldname)) { 
	            token = reader.peek(); 
	            user.setEmail(reader.nextString()); 
	         } 
	         
	         if("username".equals(fieldname)) {
	        	 token = reader.peek();
	        	 user.setUsername(reader.nextString());
	         }
	         
	         if("password".equals(fieldname)) {
	        	 token = reader.peek();
	        	 user.setPassword(reader.nextString());
	         }
	      } 
	      reader.endObject(); 
	      return user; 
	   }  
	   
	   @Override 
	   public void write(JsonWriter writer, User user) throws IOException { 
	      writer.beginObject(); 
	      writer.name("name"); 
	      writer.value(user.getName()); 
	      writer.name("email"); 
	      writer.value(user.getEmail());
	      writer.name("username");
	      writer.value(user.getUsername());
	      writer.name("password");
	      writer.value(user.getPassword());
	      writer.endObject(); 
	   } 

}
