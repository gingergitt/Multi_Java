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
public class UsersDao implements InterfaceDao{
	
	private JdbcTemplate template;
	
	@Autowired
	public UsersDao(ComboPooledDataSource dataSource)
	{
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public Users userSelect(String userid) {
		
		Users user = null;
		final String sql = "SELECT * FROM users WHERE userid = ?";
		
		user = template.queryForObject(sql, new Object[] {userid}, new BeanPropertyRowMapper<Users>(Users.class));

		return user;
	}

	@Override
	public ArrayList<Users> userSelectAll() {
	
		ArrayList<Users> list = null;
		final String sql = "SELECT * FROM users";
		
		list = (ArrayList<Users>) template.query(sql,new BeanPropertyRowMapper<Users>(Users.class));
		
		for(Users user : list)
		{
			System.out.println(user.getUserid());
		}
		
		return list;
	}

	@Override
	public UserInterest UserInterestSelect(String userid) {
		
		UserInterest userinterest = null;
		final String sql = "SELECT * FROM userinterest WHERE userid = ?";
		
		userinterest = template.queryForObject(sql, new Object[] {userid}, new BeanPropertyRowMapper<UserInterest>(UserInterest.class));
	
		return userinterest;

	}

	@Override
	public ArrayList<UserInterest> interestSelectAll() {
		return null;
	}
	
	
	
	// **************************Advertisement start*****************************
	@Override
	public Advertisement AdvertisementSelect(String productname) { return null; }

	@Override
	public ArrayList<Advertisement> AdvertisementSelect_agency(String agency) { return null; }
	
	@Override
	public List<Advertisement> AdvertisementSelect_adcategory(String adcategory) { return null; }

	@Override
	public ArrayList<Advertisement> AdvertisementSelectAll() { return null; }
	// **************************Advertisement end*****************************
	
}
