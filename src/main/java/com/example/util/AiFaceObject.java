package com.example.util;

import com.baidu.aip.face.AipFace;
import org.springframework.stereotype.Component;

@Component
public class AiFaceObject {
	public String APP_ID = "19242504";
	public String API_KEY = "iaHUv3P2AmAeqXv858XWYtB7";
	public String SECRET_KEY = "eGladR5RL7FEhOOWGiwyXmkVzucGzlL3";
	public String GROUD_LIST = "User";
	    
	private AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

	public AipFace getClient(){
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		return client;
	}
	    
}
