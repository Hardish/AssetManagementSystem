package com.decepticons.assetManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.decepticons.assetManagement.entity.Request;

@RepositoryRestResource
public interface IRequestRepository extends JpaRepository<Request, Integer> {
	

}
