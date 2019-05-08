package com.decepticons.assetManagement.services;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.PrePersist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.UserAuth;
import com.decepticons.assetManagement.entity.Role;
import com.decepticons.assetManagement.entity.UserAuth;
import com.decepticons.assetManagement.repositories.IUserAuthRepository;
import com.decepticons.assetManagement.repositories.IUserAuthRepository;
import com.decepticons.assetManagement.services.protocols.IUserAuthService;
import com.decepticons.assetManagement.services.protocols.IUserAuthService;
import com.decepticons.assetManagement.util.AssetManagementUtil;

@Service
public class UserAuthService implements IUserAuthService {

	private static AssetManagementUtil util = AssetManagementUtil.getFormatter();
	private static Department dept= new Department();
	private static Role role= new Role();
	
	@Autowired
	private IUserAuthRepository userAuthRepo;

	public UserAuthService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UserAuth> findAll() {
		// TODO Auto-generated method stub
		return userAuthRepo.findAll();
	}

	
	@Override
	public UserAuth findByUserName(String userName) {
		
		UserAuth user = userAuthRepo.findByUserNameEquals(userName);
		
		if(user != null)
		{
			return user;
		}
		
		return null;
		//throw new RuntimeException("UserAuth not found witn userName=" + userName);
		
	}
	
	@Override
	public UserAuth findById(String Id) {
		Collection ids= new ArrayList();
		ids.add(Id);
		
		Collection<UserAuth> result = (Collection<UserAuth>) userAuthRepo.findAllById(ids);
		
		for(UserAuth user : result)
		{
			return user;
		}	
		throw new RuntimeException("UserAuth not found witn ID=" + Id);
		
	}

	@Override
	public void save(UserAuth UserAuth) {
		userAuthRepo.save(UserAuth);

	}

	@Override
	public void deleteById(String id) {
		userAuthRepo.deleteById(id);

	}
	
	@Override
	public void delete(UserAuth userAuth) {
		userAuthRepo.delete(userAuth);

	}

	

}
