package com.decepticons.assetManagement.services.protocols;

import java.util.List;

import org.bson.types.ObjectId;

import com.decepticons.assetManagement.entity.RequestStatus;


public interface IRequestStatusService {

	
	public List<RequestStatus> findAll();

	public void save(RequestStatus requeststatus);

	public RequestStatus getByRequestStatusId(String requeststatus);
	
	public void delete(String requeststatus);

	

	
}
