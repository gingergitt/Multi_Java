package com.sds.finalpj.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sds.finalpj.service.AdvertisementService;
import com.sds.finalpj.vo.Advertisement;
import com.sds.finalpj.vo.UserInterest;
import com.sds.finalpj.vo.Users;

@Controller
public class ChartController {

	@Autowired
	AdvertisementService advertisementservice;

	@RequestMapping(value = "/chart", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView Chart() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "chart");
		mv.setViewName("index");

		return mv;

	}

	@RequestMapping(value = "/userschart", method = { RequestMethod.GET, RequestMethod.POST })
	public void UsersChart(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("hi userschart");

		response.setContentType("text/json; charset=EUC-KR");
		JSONArray ja = new JSONArray();
		ArrayList<Advertisement> list = advertisementservice.AdvertisementSearchAll();
		ArrayList<Integer> adregister = new ArrayList<Integer>();

		int[] getmonth = new int[12];
		int[] all = new int[12];

		for (int i = 0; i < list.size(); i++) {
			Advertisement tmp = list.get(i);
			adregister.add(tmp.getRegisterdate().getMonth() + 1);
		}

		// ¿ù º° ±¤°í ¼ö
		for (int i = 0; i < adregister.size(); i++) {
			
			if (adregister.get(i) == 1) {
				getmonth[0]++;
			} else if (adregister.get(i) == 2) {
				getmonth[1]++;
			} else if (adregister.get(i) == 3) {
				getmonth[2]++;
			} else if (adregister.get(i) == 4) {
				getmonth[3]++;
			} else if (adregister.get(i) == 5) {
				getmonth[4]++;
			} else if (adregister.get(i) == 6) {
				getmonth[5]++;
			} else if (adregister.get(i) == 7) {
				getmonth[6]++;
			} else if (adregister.get(i) == 8) {
				getmonth[7]++;
			} else if (adregister.get(i) == 9) {
				getmonth[8]++;
			} else if (adregister.get(i) == 10) {
				getmonth[9]++;
			} else if (adregister.get(i) == 11) {
				getmonth[10]++;
			} else if (adregister.get(i) == 12) {
				getmonth[11]++;
			} else {

			}

		}
		
		
		for(int i=0; i< getmonth.length; i++)
		{
			if(i == 0)
			{
				all[i] = getmonth[i];
			}else
			{
				all[i] = (all[i-1] + getmonth[i]);
			}

		}

		try {		
			for(int i=0; i<getmonth.length; i++)
			{
				JSONObject obj = new JSONObject();
				obj.put("getmonth", getmonth[i]);
				obj.put("all", all[i]);
				ja.add(obj);
			}
			PrintWriter out = response.getWriter();
			out.write(ja.toJSONString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	// =====================================================================
	
	@RequestMapping(value = "/userschartpie", method = { RequestMethod.GET, RequestMethod.POST })
	public void UsersChartPie(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("hi userschartpie");

		response.setContentType("text/json; charset=EUC-KR");
		JSONArray ja = new JSONArray();
		ArrayList<Advertisement> list = advertisementservice.AdvertisementSearchAll();
	
		ArrayList<Integer> adcategory = new ArrayList<Integer>();

		int[] getcategory = new int[5];
		int[] all = new int[5];

		for (int i = 0; i < list.size(); i++) {
			Advertisement tmp = list.get(i);
			adcategory.add(tmp. + 1);
		}

		// ¿ù º° ±¤°í ¼ö
		for (int i = 0; i < adcategory.size(); i++) {
			
			if (adcategory.get(i).equals("living")) {
				getcategory[0]++;
			} else if (adcategory.get(i).equals("living")) {
				getcategory[1]++;
			} else if (adcategory.get(i).equals("living")) {
				getcategory[2]++;
			} else if (adcategory.get(i).equals("living")) {
				getcategory[3]++;
			} else if (adcategory.get(i).equals("living")) {
				getcategory[4]++;
			}  else {

			}

		}
		
		
		for(int i=0; i< getcategory.length; i++)
		{
			if(i == 0)
			{
				all[i] = getcategory[i];
			}else
			{
				all[i] = (all[i-1] + getcategory[i]);
			}

		}

		try {		
			for(int i=0; i<getcategory.length; i++)
			{
				JSONObject obj = new JSONObject();
				obj.put("getcategory", getcategory[i]);
				obj.put("all", all[i]);
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
