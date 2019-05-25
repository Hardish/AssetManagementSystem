package com.decepticons.assetManagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.decepticons.assetManagement.entity.Request;
import com.decepticons.assetManagement.repositories.IDepartmentRepository;
import com.decepticons.assetManagement.services.protocols.IRequestService;
import com.decepticons.assetManagement.services.protocols.IRequestSubTypesService;
import com.decepticons.assetManagement.services.protocols.IRequestTypesService;



@Controller
@RequestMapping("/requests")
public class RequestController {

	@Autowired
	private IRequestService reqService;
	@Autowired
	private IDepartmentRepository deptRepo;
	@Autowired
	private IRequestTypesService reqtypeRepo;
	@Autowired
	private IRequestSubTypesService reqsubtypeRepo;
	
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
	
//	@GetMapping("/list/search")
//	public String listRequests(Model model,@ModelAttribute("reqRecord") Request req,BindingResult result)
//	{
//		 List<Request> request = this.reqService.getAllRequests(req.getRequestfirstname());
//		//requests.getAllRequests(req.getRequestfirstname());
//		model.addAttribute("request", request);
//		//model.addAttribute("requests", requests);
//		return "search-Requests";
//		
//	}
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		Request req = new Request();
		model.addAttribute("reqRecord", req);
		//department name in ascending order
		model.addAttribute("departments", deptRepo.findAll(new Sort(Sort.Direction.ASC, "deptName")));
		model.addAttribute("requesttypes",reqtypeRepo.findAll());
		model.addAttribute("requestsubtypes", reqsubtypeRepo.findAll());
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
		model.addAttribute("requesttypes",reqtypeRepo.findAll());
		model.addAttribute("requestsubtypes", reqsubtypeRepo.findAll());
		model.addAttribute("departments", deptRepo.findAll(new Sort(Sort.Direction.ASC, "deptName")));
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
