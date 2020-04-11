package com.sds.finalpj.dao;

import java.util.ArrayList;
import java.util.List;

import com.sds.finalpj.vo.Advertisement;
import com.sds.finalpj.vo.UserInterest;
import com.sds.finalpj.vo.Users;

public interface InterfaceDao {
	
	//users
	Users userSelect(String userid);
	ArrayList<Users> userSelectAll();
	UserInterest UserInterestSelect(String userid);
	ArrayList<UserInterest> interestSelectAll();
	
	//advertisement
	Advertisement AdvertisementSelect(String productname);
	ArrayList<Advertisement> AdvertisementSelect_agency(String agency);
	List<Advertisement> AdvertisementSelect_adcategory(String adcategory);
	ArrayList<Advertisement> AdvertisementSelectAll();
}
