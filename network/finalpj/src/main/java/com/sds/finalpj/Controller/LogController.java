package com.sds.finalpj.Controller;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogController {
	
	Logger logger = LoggerFactory.getLogger(LogController.class);

	@RequestMapping("/logging")
	public void logging(Model model) {
		
		System.out.println("logging");
		
		Timer jobScheduler = new Timer(false); 
		Calendar date = Calendar.getInstance();   
		date.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);   
		date.set(Calendar.AM_PM, Calendar.AM);   
		date.set(Calendar.HOUR, 9);   
		date.set(Calendar.MINUTE, 40);   
		date.set(Calendar.SECOND, 0);   
		date.set(Calendar.MILLISECOND, 0);     
		jobScheduler.scheduleAtFixedRate(new ScheduledJob(),date.getTime(), 1000 * 60 * 60 * 24);

	}
	
	class ScheduledJob extends TimerTask{

		@Override
		public void run() {
			System.out.println("TimerTask logging");
			logger.info("Age,Gender,Living,Food,Fashion,Culture,ETC,Link,LinkTime,Ad,AdTime");
		}

	}	

}
