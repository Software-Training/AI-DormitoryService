package com.example.util;


import com.baidu.aip.face.AipFace;
import com.example.bean.Image;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class FaceRegistration {
	
	public String Faceregistrtion(AipFace client, String groupList, Image image){
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("user_info", "user's info");
	    options.put("quality_control", "NORMAL");
	    options.put("liveness_control", "NORMAL");
	    JSONObject res = client.addUser(image.getImgStr(), image.getImgType(), groupList, image.getImgId(), options);
		return res.toString(2);
	}
	
}
