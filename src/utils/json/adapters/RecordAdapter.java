package utils.json.adapters;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import model.Record;

public class RecordAdapter extends TypeAdapter<Record> {
	
	  @Override 
	   public Record read(JsonReader reader) throws IOException { 
	      Record record = new Record(); 
	      reader.beginObject(); 
	      String fieldname = null; 
	      
	      while (reader.hasNext()) { 
	         JsonToken token = reader.peek();            
	         
	         if (token.equals(JsonToken.NAME)) {      
	            fieldname = reader.nextName(); 
	         } 
	         
	         if ("id_platform".equals(fieldname)) {       
	           
	            token = reader.peek(); 
	            record.setId_platform(reader.nextInt()); 
	         } 
	         
	         if("id_user".equals(fieldname)) { 
	            token = reader.peek(); 
	            record.setId_user(reader.nextInt()); 
	         } 
	      } 
	      reader.endObject(); 
	      return record; 
	   }  
	   
	   @Override 
	   public void write(JsonWriter writer, Record record) throws IOException { 
	      writer.beginObject(); 
	      writer.name("id_platform"); 
	      writer.value(record.getId_platform()); 
	      writer.name("id_user"); 
	      writer.value(record.getId_user());
	      writer.endObject(); 
	   } 

}
