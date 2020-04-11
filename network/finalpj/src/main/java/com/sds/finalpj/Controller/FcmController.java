package com.sds.finalpj.Controller;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FcmController {

	@RequestMapping(value = "/fcm", method = { RequestMethod.GET, RequestMethod.POST })
	public void fcm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("hi fcm");

		String ip = request.getParameter("ip");
		String speed = request.getParameter("speed");

		System.out.println("ip : " + ip);
		System.out.println("speed : " + speed);

		URL url = new URL("https://fcm.googleapis.com/fcm/send");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);

		conn.setRequestProperty("Authorization",
				"key=AAAA6dOwMkQ:APA91bEkmLbN6Fvg-uAHNVOnNO7gbfDt6hgfYR1WInC8myIQviXdUIpC5F65wJvVVQ5G1ClRB49RNqFf4TGj-_zK_7IPmYCen8E509jXdz6bAcyeQPPBrp6xoM5gGZ1b5NpqMDp43qiN");
		conn.setRequestProperty("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("to","e5YHYOgrvXk:APA91bG3CV853zSOEr5_WKcS0m5xqva9fnV2dePFZfknBdjg8DzIy4X545_nlsMHivkGkSe_T2y_LvjmOapjKToOUfGH4VOs5Y1Hk4P86rSP6F39VMg_ytp4PN-gutWIW-nYO8pV6LlH");

		JSONObject info = new JSONObject();
		info.put("title", ip);
		info.put("body", speed);

		json.put("notification", info);

		OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
		out.write(json.toString());
		out.flush();
		conn.getInputStream();

	}
	
}
