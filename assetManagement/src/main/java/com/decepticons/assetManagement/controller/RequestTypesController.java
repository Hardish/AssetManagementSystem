package com.decepticons.assetManagement.controller;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.decepticons.assetManagement.entity.RequestTypes;
import com.decepticons.assetManagement.services.protocols.IRequestTypesService;

@Controller
@RequestMapping("/requesttypes")
public class RequestTypesController 
{
	@Autowired
	private IRequestTypesService reqtypesService;
	
	private List<RequestTypes> requesttypes;
	
	
	
	
	@PostConstruct
	public void loadData()
	{
		requesttypes = new ArrayList<RequestTypes>(reqtypesService.findAll());
	}

	
	@GetMapping("/list")
	public String listRequestTypes(Model model)
	{
		loadData();
		model.addAttribute("requesttypes", requesttypes);
		return "list-Requesttypes";
		
	}
}
