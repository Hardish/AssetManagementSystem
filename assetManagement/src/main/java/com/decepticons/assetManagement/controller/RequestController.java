package com.decepticons.assetManagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.decepticons.assetManagement.entity.Request;
import com.decepticons.assetManagement.services.protocols.IRequestService;



@Controller
@RequestMapping("/requests")
public class RequestController {

	@Autowired
	private IRequestService reqService;
	
	private List<Request> requests;
	
	@PostConstruct
	public void loadData()
	{
		requests = new ArrayList<Request>(reqService.findAll());
	}

	
	@GetMapping("/list")
	public String listRequests(Model model)
	{
		loadData();
		model.addAttribute("requests", requests);
		return "list-Requests";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		Request req = new Request();
		model.addAttribute("reqRecord", req);
		
		return "requests/RequestForm";
	}
	
	@PostMapping("/save")
	public String saveRequestData(@ModelAttribute("reqRecord") Request req)
	{
		reqService.save(req);
		
		System.out.println("Saved "+req);
		return "redirect:/requests/list";
	}
	
	@GetMapping("/showForForUpdate")
	public String showFormForUpdate(@RequestParam("requestid") int Id, Model model)
	{
		Request req = reqService.findById(Id);
		model.addAttribute("reqRecord",req);
		
		return "requests/RequestForm";
	}
	
	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("requestid") int Id, Model model)
	{
		Request req = reqService.findById(Id);
		
		reqService.deleteById(Id);
		
		System.out.println("Deleted "+req);
		return "redirect:/requests/list";
	}
	
	
}
