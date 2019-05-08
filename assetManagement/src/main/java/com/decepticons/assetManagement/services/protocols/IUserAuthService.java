package com.decepticons.assetManagement.services.protocols;

import java.util.List;

import com.decepticons.assetManagement.entity.UserAuth;


public interface IUserAuthService {

	public List<UserAuth> findAll();

	public UserAuth findById(String Id);
	public UserAuth findByUserName(String userName);
	
	public void save (UserAuth UserAuth);
	public void deleteById(String id);
	public void delete(UserAuth userAuth);
}
