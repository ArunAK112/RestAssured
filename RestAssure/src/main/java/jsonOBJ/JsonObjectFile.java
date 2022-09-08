package jsonOBJ;

import java.util.Random;

import org.json.simple.JSONObject;

public class JsonObjectFile {
	
	public Object jsonObjectFile()
	{
		Random ran = new Random();
		int randomNum = ran.nextInt(100);
		
		JSONObject jsob = new JSONObject();
		jsob.put("createdBy", "ArunPunk");
		jsob.put("projectName", "WWE"+randomNum);
		jsob.put("status", "Created");
		jsob.put("teamSize", 30);
		
		return jsob;
	}

}
