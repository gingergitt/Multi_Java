package com.sds.finalpj.service;

import java.util.ArrayList;
import java.util.List;

import com.sds.finalpj.vo.Advertisement;
import com.sds.finalpj.vo.UserInterest;
import com.sds.finalpj.vo.Users;

public interface InterfaceService {
	
	//users
	Users userSearch(String userid);
	ArrayList<Users> userSearchAll();
	UserInterest UserInterestSearch(String userid);
	ArrayList<UserInterest> interestSearchAll();
	
	//advertisement
	Advertisement AdvertisementSearch(String productname);
	ArrayList<Advertisement> AdvertisementSearch_agency(String agency);
	List<Advertisement> AdvertisementSearch_adcategory(String adcategory);
	ArrayList<Advertisement> AdvertisementSearchAll();

}
