package com.sds.finalpj.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sds.finalpj.service.UsersService;
import com.sds.finalpj.vo.UserInterest;
import com.sds.finalpj.vo.Users;

@Controller
public class TableController {

	@Autowired
	UsersService usersservice;

	@RequestMapping("/table")
	public ModelAndView table() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "table");
		mv.setViewName("index");

		return mv;
	}

	@RequestMapping("/tablegetdata")
	public void tablegetdata(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/json; charset=EUC-KR");
		JSONArray ja = new JSONArray();
		ArrayList<Users> list = usersservice.userSearchAll();
		
		try {
			
			for (Users user : list) {
				JSONObject obj = new JSONObject();
				obj.put("userid", user.getUserid());
				obj.put("userpwd", user.getUserpwd());
				obj.put("userage", user.getUserage());
				obj.put("usergender", user.getUsergender());
				obj.put("userphone", user.getUserphone());
				obj.put("useremail", user.getUseremail());
				obj.put("useragree", user.getUseragree());
				UserInterest tmp = usersservice.UserInterestSearch(user.getUserid());
				obj.put("living", tmp.getLiving());
				obj.put("food", tmp.getFood());
				obj.put("fashion", tmp.getFashion());
				obj.put("culture", tmp.getCulture());
				obj.put("etc", tmp.getEtc());
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
