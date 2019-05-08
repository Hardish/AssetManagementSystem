package com.decepticons.assetManagement.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.decepticons.assetManagement.entity.RequestTypes;

@Repository
public interface IRequestTypesRepository extends MongoRepository<RequestTypes, String> 
{
	public RequestTypes findByRequesttype(String requesttype);
	public void deleteByRequesttype(String requesttype);
//	Optional<RequestTypes> findByRequestType(String requesttype);
//
//	void deleteByRequestType(String requesttype);

	
}