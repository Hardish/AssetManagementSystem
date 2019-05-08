package com.decepticons.assetManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.RequestTypeEmp;
import com.decepticons.assetManagement.repositories.IRequestTypeEmpRepository;
import com.decepticons.assetManagement.services.protocols.IRequestTypeEmpService;

@Service
public class RequestTypeEmpService implements IRequestTypeEmpService
{
	@Autowired
	private IRequestTypeEmpRepository reqtypeempRepo;
	
	public RequestTypeEmpService()
	{
		
	}

	@Override
	public List<RequestTypeEmp> findAll() {
		// TODO Auto-generated method stub
		return reqtypeempRepo.findAll();
	}

	@Override
	public RequestTypeEmp findById(int Id) {
		// TODO Auto-generated method stub
		Optional<RequestTypeEmp> result = reqtypeempRepo.findById(Id);
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
	public void save(RequestTypeEmp requesttypeemp) {
		reqtypeempRepo.save(requesttypeemp);
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		reqtypeempRepo.deleteById(id);
	}
	
}
