package com.sds.finalpj.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sds.finalpj.vo.Advertisement;
import com.sds.finalpj.vo.UserInterest;
import com.sds.finalpj.vo.Users;

@Repository
public class AdvertisementDao implements InterfaceDao{
	
	private JdbcTemplate template;
	
	@Autowired
	public AdvertisementDao(ComboPooledDataSource dataSource)
	{
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Advertisement AdvertisementSelect(String productname) {
		return null;
	}

	@Override
	public ArrayList<Advertisement> AdvertisementSelect_agency(String agency) {
		return null;
	}
	
	@Override
	public List<Advertisement> AdvertisementSelect_adcategory(String adcategory) {
		
		List<Advertisement> list = null;
		final String sql = "SELECT * FROM advertisement where adcategory = ?";
		
		list = template.query(sql, new Object[] {adcategory}, new BeanPropertyRowMapper<Advertisement>(Advertisement.class));
		
		return list;
	}

	@Override
	public ArrayList<Advertisement> AdvertisementSelectAll() {
		
		ArrayList<Advertisement> list = null;
		final String sql = "SELECT * FROM advertisement";
		
		list = (ArrayList<Advertisement>) template.query(sql,new BeanPropertyRowMapper<Advertisement>(Advertisement.class));
		
		return list;
	}
	
	

	// **************************User start*****************************
	@Override
	public Users userSelect(String userid) { return null; }

	@Override
	public ArrayList<Users> userSelectAll() { return null; }

	@Override
	public UserInterest UserInterestSelect(String userid) { return null; }

	@Override
	public ArrayList<UserInterest> interestSelectAll() { return null; }
	// **************************User end*****************************

}
