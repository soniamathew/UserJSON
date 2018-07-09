package readwrite;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Userrw {
 
 public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	 
 //read from input file :
	 
  JSONParser parser = new JSONParser();
 
   Object obj = parser.parse(new FileReader("/Users/tekion/eclipse-workspace/userdetails/input.JSON"));
 
   JSONObject jsonObject = (JSONObject) obj;
 
   String firstname = (String) jsonObject.get("First Name");
   System.out.println("First Name: "+firstname);
 
   String lastname = (String) jsonObject.get("Last Name");
   System.out.println("Last Name: "+lastname);
 
   System.out.println("Address :");
   Map address = ((Map)jsonObject.get("Address"));
   
   // iterating address Map :
   
   Iterator<Map.Entry> itr1 = address.entrySet().iterator();
   while (itr1.hasNext()) {
       Map.Entry pair = itr1.next();
       System.out.println(pair.getKey() + " : " + pair.getValue());
  }
 
  
  //write to output file :
   JSONArray userList = new JSONArray();
   userList.add(jsonObject);
   try (FileWriter file = new FileWriter("/Users/tekion/eclipse-workspace/userdetails/output.json")) {
	   
       file.write(userList.toJSONString());
       file.flush();

   } catch (IOException e) {
       e.printStackTrace();
   }
	  
 }
}