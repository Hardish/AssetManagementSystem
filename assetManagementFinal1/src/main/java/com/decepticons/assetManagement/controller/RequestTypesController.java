package com.decepticons.assetManagement.controller;

import java.util.*;

import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.decepticons.assetManagement.entity.Request;
import com.decepticons.assetManagement.entity.RequestTypes;
import com.decepticons.assetManagement.repositories.IDepartmentRepository;
import com.decepticons.assetManagement.repositories.IRoleRepository;
import com.decepticons.assetManagement.services.protocols.IRequestTypesService;

@Controller
@RequestMapping("/requesttypes")
public class RequestTypesController 
{
	@Autowired
	private IRequestTypesService reqtypesService;
	@Autowired
	private IRoleRepository roleRepo;
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
	
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		RequestTypes req = new RequestTypes();
		model.addAttribute("reqRecord", req);
		model.addAttribute("roles", roleRepo.findAll());
		return "requesttypes/RequesttypesForm";
	}
	
	@PostMapping("/save")
	public String saveRequestData(@ModelAttribute("reqRecord") RequestTypes req)
	{
		reqtypesService.save(req);
		
		System.out.println("Saved "+req);
		return "redirect:/requesttypes/list";
	}
	

	@GetMapping("/showForForUpdate")
	public String showFormForUpdate(@RequestParam("requesttype") String requesttype, Model model)
	{
		RequestTypes req = reqtypesService.getByRequestType(requesttype);
		model.addAttribute("reqRecord",req);
		model.addAttribute("roles", roleRepo.findAll());
		return "requesttypes/RequesttypesForm";
	}
	
	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam String requesttype, Model model)
	{
		RequestTypes req = reqtypesService.getByRequestType(requesttype);
		reqtypesService.delete(requesttype);
		System.out.println("Deleted "+req);
		return "redirect:/requesttypes/list";
	}
	
	
}
