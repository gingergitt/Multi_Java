package com.sds.finalpj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {

	@RequestMapping(value = "/map", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "map");
		mv.setViewName("index");
		
		return mv;
		
	}


}
