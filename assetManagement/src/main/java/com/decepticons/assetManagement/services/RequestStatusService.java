package com.decepticons.assetManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.Request;
import com.decepticons.assetManagement.entity.RequestStatus;
import com.decepticons.assetManagement.repositories.IRequestStatusRepository;
import com.decepticons.assetManagement.services.protocols.IRequestStatusService;
@Service
public class RequestStatusService implements IRequestStatusService {
	@Autowired
	private IRequestStatusRepository reqRepo;
	
	public RequestStatusService()
	{
		
	}


	@Override
	public RequestStatus getByRequestStatusId(String requeststatus) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(String requeststatus) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<RequestStatus> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void save(RequestStatus requeststatus) {
		// TODO Auto-generated method stub
		
	}

	
	



}
