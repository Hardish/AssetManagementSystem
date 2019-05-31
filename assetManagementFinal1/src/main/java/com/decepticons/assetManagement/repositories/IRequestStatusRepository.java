package com.decepticons.assetManagement.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.decepticons.assetManagement.entity.RequestStatus;

@Repository
public interface IRequestStatusRepository extends MongoRepository<RequestStatus, String> 
{
	public RequestStatus findByRequeststatus(String requeststatus);

}