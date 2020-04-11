package com.sds.finalpj.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sds.finalpj.service.AdvertisementService;
import com.sds.finalpj.vo.Advertisement;

@Controller
public class PlaylistController {
	
	@Autowired
	AdvertisementService advertisementservice;

	@RequestMapping("/playlist")
	public ModelAndView playlist() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "playlist");
		mv.setViewName("index");

		return mv;
	}
	
	@RequestMapping("/playlistgetdata")
	public void playlistgetdata(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/json; charset=EUC-KR");
		JSONArray ja = new JSONArray();
		ArrayList<Advertisement> list = advertisementservice.AdvertisementSearchAll();
		
		try {
			
			for(Advertisement tmp : list) {
				JSONObject obj = new JSONObject();
				obj.put("productname",tmp.getProductname());
				obj.put("adcategory",tmp.getCategory());
				obj.put("agency",tmp.getAgency());
				obj.put("adurl",tmp.getAdurl());
				obj.put("subscriptionlevel",tmp.getSubscriptionlevel());
				//obj.put("registerdate",tmp.getRegisterdate());
				obj.put("totalplayingtime",tmp.getTotalplayingtime());
				obj.put("playingtime",tmp.getPlayingtime());
				ja.add(obj);
			}
			
			PrintWriter out = response.getWriter();
			out.write(ja.toJSONString());
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/playlistfilter")
	public void playlistfilter(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/json; charset=EUC-KR");
		JSONArray ja = new JSONArray();
		String adcategory = request.getParameter("adcategory");
		System.out.println(adcategory);
		List<Advertisement> list = advertisementservice.AdvertisementSearch_adcategory(adcategory);		
			
		try {
			
			for(Advertisement tmp : list) {
				JSONObject obj = new JSONObject();
				obj.put("productname",tmp.getProductname());
				obj.put("adcategory",tmp.getCategory());
				obj.put("agency",tmp.getAgency());
				obj.put("adurl",tmp.getAdurl());
				obj.put("subscriptionlevel",tmp.getSubscriptionlevel());
				//obj.put("registerdate",tmp.getRegisterdate());
				obj.put("totalplayingtime",tmp.getTotalplayingtime());
				obj.put("playingtime",tmp.getPlayingtime());
				ja.add(obj);
			}
			
			PrintWriter out = response.getWriter();
			out.write(ja.toJSONString());
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
