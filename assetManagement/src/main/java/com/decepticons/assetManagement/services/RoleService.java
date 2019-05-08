package com.decepticons.assetManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.Role;
import com.decepticons.assetManagement.repositories.IRoleRepository;
import com.decepticons.assetManagement.services.protocols.IRoleService;

@Service
public class RoleService implements IRoleService
{
	@Autowired
	private IRoleRepository roleRepo;
	public RoleService(){}
	
	@Override
	public List<Role> findAll() {
		return roleRepo.findAll();
	}

	@Override
	public Role findById(int Id) {
		Optional<Role> result = roleRepo.findById(Id);
		if(result.isPresent())
		{
			return result.get();
		}
		else
		{
			throw new RuntimeException("Role not found witn ID=" + Id); 
		}
	}

	@Override
	public void save(Role role) {
		roleRepo.save(role);
	}

	@Override
	public void deleteById(int id) {
		roleRepo.deleteById(id);
	}
	
}
