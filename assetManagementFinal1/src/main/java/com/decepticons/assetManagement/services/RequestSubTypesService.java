package com.decepticons.assetManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.RequestSubTypes;
import com.decepticons.assetManagement.entity.RequestTypes;
import com.decepticons.assetManagement.repositories.IRequestSubTypesRepository;
import com.decepticons.assetManagement.services.protocols.IRequestSubTypesService;
@Service
public class RequestSubTypesService implements IRequestSubTypesService {

	@Autowired
	private IRequestSubTypesRepository reqtypesRepo;
	
	
	@Override
	public List<RequestSubTypes> findAll() {
		// TODO Auto-generated method stub
		return reqtypesRepo.findAll();
	}

	@Override
	public void save(RequestSubTypes requestsubtypes) {
		// TODO Auto-generated method stub
		reqtypesRepo.save(requestsubtypes);
	}

	@Override
	public RequestSubTypes getByRequestSubType(String requestsubtype) {
		// TODO Auto-generated method stub
		RequestSubTypes result = reqtypesRepo.findByRequestsubtype(requestsubtype);
		return result;
	}

	@Override
	public void delete(String requestsubtype) {
		// TODO Auto-generated method stub
		RequestSubTypes p = reqtypesRepo.findByRequestsubtype(requestsubtype);
		reqtypesRepo.delete(p);
	}



}
