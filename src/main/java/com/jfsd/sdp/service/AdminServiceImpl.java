package com.jfsd.sdp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.sdp.model.Admin;
import com.jfsd.sdp.model.Nutritionist;
import com.jfsd.sdp.model.User;
import com.jfsd.sdp.repository.AdminRepository;
import com.jfsd.sdp.repository.NutritionistRepository;
import com.jfsd.sdp.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService 
{
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NutritionistRepository nutritionistRepository;

	@Override
	public Admin checkadminlogin(String uname, String pwd) 
	{
		
		return adminRepository.checkadminlogin(uname, pwd);
	}

	@Override
	public List<User> viewallUsers() 
	{
		return userRepository.findAll();
	}

	@Override
	public String deleteuser(int uid) 
	{
		userRepository.deleteById(uid);
		return "user deleted successfully";
	}

	@Override
	public List<Nutritionist> viewallnutrisiosinists() 
	{
		return nutritionistRepository.findAll();
	}

	@Override
	public String deleteNutrisionist(int id) 
	{
		nutritionistRepository.deleteById(id);
		return "Nutritisionist Deleted Successfully ";
	}
}
