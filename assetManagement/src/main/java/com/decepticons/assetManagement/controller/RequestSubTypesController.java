package com.decepticons.assetManagement.controller;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.decepticons.assetManagement.entity.RequestSubTypes;

import com.decepticons.assetManagement.repositories.IRequestTypesRepository;
import com.decepticons.assetManagement.services.protocols.IRequestSubTypesService;

@Controller
@RequestMapping("/requestsubtypes")
public class RequestSubTypesController 
{
	@Autowired
	private IRequestSubTypesService reqtypesService;
	@Autowired
	private IRequestTypesRepository reqtypeRepo;
	
	
	private List<RequestSubTypes> requestsubtypes;
	
	@PostConstruct
	public void loadData()
	{
		requestsubtypes = new ArrayList<RequestSubTypes>(reqtypesService.findAll());
	}

	
	@GetMapping("/list")
	public String listRequestSubTypes(Model model)
	{
		loadData();
		model.addAttribute("requestsubtypes", requestsubtypes);
		return "list-Requestsubtypes";
		
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		RequestSubTypes req = new RequestSubTypes();
		model.addAttribute("reqRecord", req);
		model.addAttribute("requesttypes", reqtypeRepo.findAll());
		return "requestsubtypes/RequestsubtypesForm";
	}
	
	@PostMapping("/save")
	public String saveRequestData(@ModelAttribute("reqRecord") RequestSubTypes req)
	{
		reqtypesService.save(req);
		
		System.out.println("Saved "+req);
		return "redirect:/requestsubtypes/list";
	}
	

	@GetMapping("/showForForUpdate")
	public String showFormForUpdate(@RequestParam("requestsubtype") String requestsubtype, Model model)
	{
		RequestSubTypes req = reqtypesService.getByRequestSubType(requestsubtype);
		model.addAttribute("reqRecord",req);
		model.addAttribute("requesttypes", reqtypeRepo.findAll());
		return "requestsubtypes/RequestsubtypesForm";
	}
	
	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam String requestsubtype, Model model)
	{
		RequestSubTypes req = reqtypesService.getByRequestSubType(requestsubtype);
		reqtypesService.delete(requestsubtype);
		System.out.println("Deleted "+req);
		return "redirect:/requestsubtypes/list";
	}
	
	
}
