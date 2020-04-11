package com.sds.finalpj;

import java.util.Random;
import java.util.Scanner;

/*
 * 
 * living food fashion culture etc
 * 
	create table etc(
    	productname varchar2(50) primary key,
    	agency varchar2(50),
    	adurl varchar2(100),
    	subscriptionlevel varchar2(10),
    	registerdate date,
    	totalplayingtime varchar2(20),
    	playingtime varchar2(20)
	);
 *
 */
       	  	  
public class CreateQuery {
	
	public static void main(String[] args) {
		
		StringBuilder query = new StringBuilder();
		Random rand = new Random();
		
		String[] livingagency = {"ikea", "hanssem", "sk", "kt", "lg", "samsung"};
		String[] foodagency = {"ottogi", "nongshim", "paldo", "pulmuone", "lotte chilsung", "samyang"};
		String[] fashionagency = {"nike", "louisvuitton", "CHANEL", "Hermes", "Prada", "SAINT LAURENT"};
		String[] cultureagency = {"cgv", "lotte world", "EVERLAND", "Seoul Land", "Seoul Grand Park"};
		String[] etcagency = {"basketball","baseball","soccer","bicycle","Kintex","COEX"};

		String[] subscriptionlevel = {"basic","premium"};
		String[] registerdate = {"19-12-14","19-10-20","20-01-11","18-07-09","19-12-11","20-03-21","18-07-21","19-10-01","19-12-11"};
		String[] totalplayingtime = {"137","42","67","256","109","14","13","21","37","80"};	

		System.out.println("쿼리문 각 몇개씩?");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		//insert into living values('BOMARKEN','ikea','<iframe class="img-thumbnail" src="https://www.youtube.com/embed/yshNZlWezDk\" allowfullscreen=""></iframe>',
		//'basic','21/03/20','137','1');
		
		System.out.println("---------------living-----------------");
		
		for (int i = 0; i < n; i++) {

			int livingagencyrand = rand.nextInt(livingagency.length);
			
			int subscriptionlevelrand = rand.nextInt(subscriptionlevel.length);			
			int registerdaterand = rand.nextInt(registerdate.length);
			int totalplayingtimerand = rand.nextInt(totalplayingtime.length);
			
			query.append("INSERT INTO living values('', '");
			query.append(livingagency[livingagencyrand] + "', '', '");
			query.append(subscriptionlevel[subscriptionlevelrand] + "', '");
			query.append(registerdate[registerdaterand] + "', '");
			query.append(totalplayingtime[totalplayingtimerand] + "', '1');");

			System.out.println(query);
			query.delete(0, query.length());
		}
		
		System.out.println("---------------food-----------------");
		
		for (int i = 0; i < n; i++) {
			
			int foodagencyrand = rand.nextInt(foodagency.length);
			
			int subscriptionlevelrand = rand.nextInt(subscriptionlevel.length);			
			int registerdaterand = rand.nextInt(registerdate.length);
			int totalplayingtimerand = rand.nextInt(totalplayingtime.length);
			
			query.append("INSERT INTO food values('', '");
			query.append(foodagency[foodagencyrand] + "', '', '");
			query.append(subscriptionlevel[subscriptionlevelrand] + "', '");
			query.append(registerdate[registerdaterand] + "', '");
			query.append(totalplayingtime[totalplayingtimerand] + "', '1');");
			
			System.out.println(query);
			query.delete(0, query.length());
		}
		
		System.out.println("---------------fashion-----------------");
		
		for (int i = 0; i < n; i++) {
			
			int fashionagencyrand = rand.nextInt(fashionagency.length);
			
			int subscriptionlevelrand = rand.nextInt(subscriptionlevel.length);			
			int registerdaterand = rand.nextInt(registerdate.length);
			int totalplayingtimerand = rand.nextInt(totalplayingtime.length);
			
			query.append("INSERT INTO fashion values('', '");
			query.append(fashionagency[fashionagencyrand] + "', '', '");
			query.append(subscriptionlevel[subscriptionlevelrand] + "', '");
			query.append(registerdate[registerdaterand] + "', '");
			query.append(totalplayingtime[totalplayingtimerand] + "', '1');");
			
			System.out.println(query);
			query.delete(0, query.length());
			
		}
		
		System.out.println("---------------culture-----------------");
		
		for (int i = 0; i < n; i++) {

			int cultureagencyrand = rand.nextInt(cultureagency.length);
			
			int subscriptionlevelrand = rand.nextInt(subscriptionlevel.length);			
			int registerdaterand = rand.nextInt(registerdate.length);
			int totalplayingtimerand = rand.nextInt(totalplayingtime.length);
			
			query.append("INSERT INTO culture values('', '");
			query.append(cultureagency[cultureagencyrand] + "', '', '");
			query.append(subscriptionlevel[subscriptionlevelrand] + "', '");
			query.append(registerdate[registerdaterand] + "', '");
			query.append(totalplayingtime[totalplayingtimerand] + "', '1');");
			
			System.out.println(query);
			query.delete(0, query.length());
		}
		
		System.out.println("---------------etc-----------------");
		
		for (int i = 0; i < n; i++) {
			
			int etcagencyrand = rand.nextInt(etcagency.length);
			
			int subscriptionlevelrand = rand.nextInt(subscriptionlevel.length);			
			int registerdaterand = rand.nextInt(registerdate.length);
			int totalplayingtimerand = rand.nextInt(totalplayingtime.length);
			
			query.append("INSERT INTO etc values('', '");
			query.append(etcagency[etcagencyrand] + "', '', '");
			query.append(subscriptionlevel[subscriptionlevelrand] + "', '");
			query.append(registerdate[registerdaterand] + "', '");
			query.append(totalplayingtime[totalplayingtimerand] + "', '1');");
			
			System.out.println(query);
			query.delete(0, query.length());
		}
			
			
		}
		
	}


