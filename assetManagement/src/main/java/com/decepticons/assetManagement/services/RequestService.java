package com.decepticons.assetManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.Request;
import com.decepticons.assetManagement.repositories.IRequestRepository;
import com.decepticons.assetManagement.services.protocols.IRequestService;

@Service
public class RequestService implements IRequestService
{
	@Autowired
	private IRequestRepository reqRepo;
	
	public RequestService()
	{
		
	}
	@Override
	public List<Request> findAll() {
		// TODO Auto-generated method stub
		return reqRepo.findAll();
	}

	@Override
	public Request findById(int Id) {
		// TODO Auto-generated method stub
		Optional<Request> result = reqRepo.findById(Id);
		if(result.isPresent())
		{
			return result.get();
		}
		else
		{
			throw new RuntimeException("Request not found witn ID=" + Id); 
		}
	}

	@Override
	public void save(Request request) {
		reqRepo.save(request);
	}

	@Override
	public void deleteById(int id) {
		reqRepo.deleteById(id);
	}
	
}
