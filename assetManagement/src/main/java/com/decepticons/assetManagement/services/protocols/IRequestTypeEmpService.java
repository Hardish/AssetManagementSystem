package com.decepticons.assetManagement.services.protocols;

import java.util.List;
import java.util.Optional;

import com.decepticons.assetManagement.entity.RequestTypeEmp;


public interface IRequestTypeEmpService {

	public List<RequestTypeEmp> findAll();

	public RequestTypeEmp findById(int Id);
	public void save (RequestTypeEmp requesttypeemp);
	public void deleteById(int id);
}
