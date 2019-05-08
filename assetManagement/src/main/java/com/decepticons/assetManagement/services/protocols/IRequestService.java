package com.decepticons.assetManagement.services.protocols;

import java.util.List;
import java.util.Optional;

import com.decepticons.assetManagement.entity.Request;


public interface IRequestService {

	public List<Request> findAll();

	public Request findById(int Id);
	public void save (Request request);
	public void deleteById(int id);
}
