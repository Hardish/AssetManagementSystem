package com.decepticons.assetManagement.services.protocols;

import java.util.List;
import java.util.Optional;

import com.decepticons.assetManagement.entity.RequestTypeSA;


public interface IRequestTypeSAService {

	public List<RequestTypeSA> findAll();

	public RequestTypeSA findById(int Id);
	public void save (RequestTypeSA requesttypesa);
	public void deleteById(int id);
}
