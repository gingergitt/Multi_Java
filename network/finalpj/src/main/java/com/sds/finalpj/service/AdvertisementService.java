package com.sds.finalpj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.finalpj.dao.AdvertisementDao;
import com.sds.finalpj.vo.Advertisement;
import com.sds.finalpj.vo.UserInterest;
import com.sds.finalpj.vo.Users;

@Service
public class AdvertisementService implements InterfaceService{
	
	@Autowired
	AdvertisementDao advertisementDao;

	@Override
	public Advertisement AdvertisementSearch(String productname) {
		return null;
	}

	@Override
	public ArrayList<Advertisement> AdvertisementSearch_agency(String agency) {
		return null;
	}

	@Override
	public List<Advertisement> AdvertisementSearch_adcategory(String adcategory) {
		
		List<Advertisement> list = advertisementDao.AdvertisementSelect_adcategory(adcategory);
		
		return list;
	}

	// ¿©±â~~~~~~~~~~
	@Override
	public ArrayList<Advertisement> AdvertisementSearchAll() {
		
		ArrayList<Advertisement> list = advertisementDao.AdvertisementSelectAll();
		
		return list;
	}
	
	
	// **************************User start*****************************
	@Override
	public Users userSearch(String userid) { return null; }

	@Override
	public ArrayList<Users> userSearchAll() { return null; }

	@Override
	public UserInterest UserInterestSearch(String userid) { return null; }

	@Override
	public ArrayList<UserInterest> interestSearchAll() { return null; }
	// **************************User end*****************************

}
