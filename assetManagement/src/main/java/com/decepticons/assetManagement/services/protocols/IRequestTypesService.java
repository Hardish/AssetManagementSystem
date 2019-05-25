package com.decepticons.assetManagement.services.protocols;

import java.util.List;

import org.bson.types.ObjectId;

import com.decepticons.assetManagement.entity.Request;
import com.decepticons.assetManagement.entity.RequestTypes;

public interface IRequestTypesService {

	
	public List<RequestTypes> findAll();

	public void save(RequestTypes requesttypes);

	public RequestTypes getByRequestType(String requesttype);
	
	
	
	public void delete(String requesttype);

	

	
}
