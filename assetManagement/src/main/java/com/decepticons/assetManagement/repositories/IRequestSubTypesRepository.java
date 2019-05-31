package com.decepticons.assetManagement.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.decepticons.assetManagement.entity.RequestSubTypes;

@Repository
public interface IRequestSubTypesRepository extends MongoRepository<RequestSubTypes, String> 
{
	public RequestSubTypes findByRequestsubtype(String requestsubtype);
	
	//public void deleteByRequesttype(String requesttype);
//	Optional<RequestTypes> findByRequestType(String requesttype);
//
//	void deleteByRequestType(String requesttype);

	
}