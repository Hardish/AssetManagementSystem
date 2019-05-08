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

import com.decepticons.assetManagement.entity.RequestTypeEmp;
import com.decepticons.assetManagement.services.protocols.IRequestTypeEmpService;



@Controller
@RequestMapping("/requesttypeemps")
public class RequestTypeEmpController {

	@Autowired
	private IRequestTypeEmpService reqtypeempService;
	
	private List<RequestTypeEmp> requesttypeemps;
	
	@PostConstruct
	public void loadData()
	{
		requesttypeemps = new ArrayList<RequestTypeEmp>(reqtypeempService.findAll());
	}

	
	@GetMapping("/list")
	public String listRequestTypeEmps(Model model)
	{
		loadData();
		model.addAttribute("requesttypeemps", requesttypeemps);
		return "list-Requesttypeemps";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		RequestTypeEmp reqtypeemp = new RequestTypeEmp();
		model.addAttribute("reqRecord", reqtypeemp);
		
		return "requesttypeemps/RequesttypeempForm";
	}
	
	@PostMapping("/save")
	public String saveRequestData(@ModelAttribute("reqRecord") RequestTypeEmp reqtypeemp)
	{
		reqtypeempService.save(reqtypeemp);
		
		System.out.println("Saved "+reqtypeemp);
		return "redirect:/requesttypeemps/list";
	}
	
	@GetMapping("/showForForUpdate")
	public String showFormForUpdate(@RequestParam("requestid") int Id, Model model)
	{
		RequestTypeEmp reqtypeemp = reqtypeempService.findById(Id);
		model.addAttribute("reqRecord",reqtypeemp);
		
		return "requesttypeemps/RequesttypeempForm";
	}
	
	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("requestid") int Id, Model model)
	{
		RequestTypeEmp reqtypeemp = reqtypeempService.findById(Id);
		
		reqtypeempService.deleteById(Id);
		
		System.out.println("Deleted "+reqtypeemp);
		return "redirect:/requesttypeemps/list";
	}
	
	
}
