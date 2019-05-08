package com.decepticons.assetManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.RequestTypes;
import com.decepticons.assetManagement.repositories.IRequestTypesRepository;
import com.decepticons.assetManagement.services.protocols.IRequestTypesService;
@Service
public class RequestTypesService implements IRequestTypesService {


	@Autowired
	private IRequestTypesRepository reqtypesRepo;
	
	
	@Override
	public List<RequestTypes> findAll() {
		// TODO Auto-generated method stub
		return reqtypesRepo.findAll();
	}

	@Override
	public void save(RequestTypes requesttypes) {
		// TODO Auto-generated method stub
		reqtypesRepo.save(requesttypes);
	}

	@Override
	public RequestTypes findByRequestType(String requesttype) {
		// TODO Auto-generated method stub
		RequestTypes result = reqtypesRepo.findByRequesttype(requesttype);
		return result;
	
	}

	@Override
	public void deleteByRequestType(String requesttype) {
		// TODO Auto-generated method stub
		reqtypesRepo.deleteByRequesttype(requesttype);
	}

}
