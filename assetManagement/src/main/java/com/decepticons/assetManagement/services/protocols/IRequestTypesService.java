package com.decepticons.assetManagement.services.protocols;

import java.util.List;

import com.decepticons.assetManagement.entity.RequestTypes;

public interface IRequestTypesService {

	
	public List<RequestTypes> findAll();

	public void save(RequestTypes requesttypes) ;

	public RequestTypes findByRequestType(String requesttype);

	public void deleteByRequestType(String requesttype) ;

	
}
