package Alagu;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class test {

	public static void main(String[] args) {
	//	String header="{'partner-id':'CSO45909084','content-length':'146','service-transaction-id':'a8e2be5cf7094f79','x-authorization':'xxX*xXXxXxXXX*XxXXXx','postman-token':'2c9a5696-458e-40de-836c-cff146583809','activity-id':'7ec0bb35-b347-4159-9c6c-0c045360f106','channel-id':'RETAIL','accept':'application/json','authorization':'Xxxxxx xxXxxXXxXxX*X','x-auth-originator':'xxXxxXXxXxX*Xxx*X*Xx','host':'localhost:8080','content-type':'application/json','connection':'keep-alive','cache-control':'no-cache','accept-encoding':'gzip, deflate, br','user-agent':'PostmanRuntime/7.29.2'}";
	//	String header="{'partner-id':'CSO45909084','content-length':'146','service-transaction-id':'a8e2be5cf7094f79','x-authorization':'xxX*xXXxXxXXX*XxXXXx','postman-token':'2c9a5696-458e-40de-836c-cff146583809','activity-id':'7ec0bb35-b347-4159-9c6c-0c045360f106','channel-id':'RETAIL','accept':'application/json','authorization':'Xxxxxx xxXxxXXxXxX*X','x-auth-originator':'xxXxxXXxXxX*Xxx*X*Xx','host':'localhost:8080','content-type':'application/json','connection':'keep-alive','cache-control':'no-cache','user-agent':'PostmanRuntime/7.29.2'}";

		String header="{\"partner-id\":\"CSO45909084\"}";
				
		//String strHeader=header.substring(1, header.length()-1);	
		System.out.println("header0000->"+header);
//		Map<String, String> result= Arrays.stream(strHeader.split("',")).map(str -> str.split("':"))
//				.collect(Collectors.toMap(key -> key[0], key -> key[1]));
		
		Type strPrint = new TypeToken<String>() {}.getType();
		String print = new Gson().fromJson(header, strPrint);
		
		System.out.println("print  **="+print);
		Type mapType = new TypeToken<Map<String, Map>>(){}.getType();  
		Map<String, String[]> result = new Gson().fromJson(header, mapType);

		System.out.println("result**="+result);
		
	}

}
