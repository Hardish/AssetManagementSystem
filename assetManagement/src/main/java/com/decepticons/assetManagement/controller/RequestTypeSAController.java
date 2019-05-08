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

import com.decepticons.assetManagement.entity.RequestTypeSA;
import com.decepticons.assetManagement.services.protocols.IRequestTypeSAService;



@Controller
@RequestMapping("/requesttypesas")
public class RequestTypeSAController {

	@Autowired
	private IRequestTypeSAService reqtypesaService;
	
	private List<RequestTypeSA> requesttypesas;
	
	@PostConstruct
	public void loadData()
	{
		requesttypesas = new ArrayList<RequestTypeSA>(reqtypesaService.findAll());
	}

	
	@GetMapping("/list")
	public String listRequestTypeSAs(Model model)
	{
		loadData();
		model.addAttribute("requesttypesas", requesttypesas);
		return "list-Requesttypesas";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		RequestTypeSA reqtypesa = new RequestTypeSA();
		model.addAttribute("reqRecord", reqtypesa);
		
		return "requesttypesas/RequesttypesaForm";
	}
	
	@PostMapping("/save")
	public String saveRequestData(@ModelAttribute("reqRecord") RequestTypeSA reqtypesa)
	{
		reqtypesaService.save(reqtypesa);
		
		System.out.println("Saved "+reqtypesa);
		return "redirect:/requesttypesas/list";
	}
	
	@GetMapping("/showForForUpdate")
	public String showFormForUpdate(@RequestParam("requestid") int Id, Model model)
	{
		RequestTypeSA reqtypesa = reqtypesaService.findById(Id);
		model.addAttribute("reqRecord",reqtypesa);
		
		return "requesttypesas/RequesttypesaForm";
	}
	
	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("requestid") int Id, Model model)
	{
		RequestTypeSA reqtypesa = reqtypesaService.findById(Id);
		
		reqtypesaService.deleteById(Id);
		
		System.out.println("Deleted "+reqtypesa);
		return "redirect:/requesttypesas/list";
	}
	
	
}
