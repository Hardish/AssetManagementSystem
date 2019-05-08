package com.decepticons.assetManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.RequestTypeEmp;
import com.decepticons.assetManagement.entity.RequestTypeSA;
import com.decepticons.assetManagement.repositories.IRequestTypeSARepository;
import com.decepticons.assetManagement.services.protocols.IRequestTypeSAService;

@Service
public class RequestTypeSAService implements IRequestTypeSAService
{
	@Autowired
	private IRequestTypeSARepository reqtypeempRepo;
	
	public RequestTypeSAService()
	{
		
	}

	@Override
	public List<RequestTypeSA> findAll() {
		// TODO Auto-generated method stub
		return reqtypeempRepo.findAll();
	}

	@Override
	public RequestTypeSA findById(int Id) {
		// TODO Auto-generated method stub
		Optional<RequestTypeSA> result = reqtypeempRepo.findById(Id);
		if(result.isPresent())
		{
			return result.get();
		}
		else
		{
			throw new RuntimeException("Request Type not found witn ID=" + Id); 
		}
	}

	@Override
	public void save(RequestTypeSA requesttypesa) {
		// TODO Auto-generated method stub
		reqtypeempRepo.save(requesttypesa);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		reqtypeempRepo.deleteById(id);
	}

	

	
}
