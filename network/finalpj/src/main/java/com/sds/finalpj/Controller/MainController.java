package com.sds.finalpj.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sds.finalpj.service.UsersService;
import com.sds.finalpj.vo.UserInterest;
import com.sds.finalpj.vo.Users;

@Controller
public class MainController {
	
	@Autowired
	UsersService usersservice;
	
	String id = null;
	String userid = null;
	ArrayList<String> idlist = new ArrayList<String>();
	
	Logger logger = LoggerFactory.getLogger(MainController.class);
			
	@RequestMapping("/clientgetdata")
	public void tablegetdata(HttpServletRequest request, HttpServletResponse response) {

		String useridtmp = request.getParameter("id");
		String reid = request.getParameter("ip");
		//age,gender,living,food,fashion,culture,etc,link,linktime,ad,adtime	
		if (useridtmp != null) {
			userid = useridtmp;
			Users logginguser = usersservice.userSearch(userid);
			UserInterest logginguserint = usersservice.UserInterestSearch(logginguser.getUserid());
			logger.info(logginguser.getUserage()+","+logginguser.getUsergender()+","+logginguserint.getLiving()+","+
				logginguserint.getFood()+","+logginguserint.getFashion()+","+logginguserint.getCulture()+","+logginguserint.getEtc()+",N,NULL,Galaxy S20 Ultra,2020-03-25 15:01:02");
		}
		
		if (reid != null) {
			id = reid;
			idlist.add(id);
		}

		if (id != null) {

			try {
				JSONArray ja = new JSONArray();

				for(String idd : idlist) {
					JSONObject obj = new JSONObject();
					obj.put("ip", idd);
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
	
	@RequestMapping("/disconnect")
	public void disconnect(HttpServletRequest request, HttpServletResponse response) {
	
	String ip = request.getParameter("ip");
	System.out.println("disconnect"+ip);
		
		for(int i = 0; i < idlist.size(); i++)
		{
			String tmp = idlist.get(i);
			if(tmp.equals(ip))
			{
				idlist.remove(i);
			}
		}

	}
	
	
}
