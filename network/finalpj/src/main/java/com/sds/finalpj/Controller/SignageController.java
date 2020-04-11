package com.sds.finalpj.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignageController {
	
	@RequestMapping(value = "/signage", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView signage(HttpServletRequest request){

		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "signage");
		mv.setViewName("index");
		
		return mv;

	}

}
