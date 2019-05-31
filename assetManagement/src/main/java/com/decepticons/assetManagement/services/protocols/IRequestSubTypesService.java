package com.decepticons.assetManagement.services.protocols;

import java.util.List;
import com.decepticons.assetManagement.entity.RequestSubTypes;
public interface IRequestSubTypesService {

	
	public List<RequestSubTypes> findAll();

	public void save(RequestSubTypes requestsubtypes);

	public RequestSubTypes getByRequestSubType(String requestsubtype);
	


	public void delete(String requestsubtype);
}
