package com.decepticons.assetManagement.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.decepticons.assetManagement.entity.UserAuth;

public interface IUserAuthRepository extends MongoRepository<UserAuth, String>{

	public UserAuth findByUserNameEquals(String userName);
}
