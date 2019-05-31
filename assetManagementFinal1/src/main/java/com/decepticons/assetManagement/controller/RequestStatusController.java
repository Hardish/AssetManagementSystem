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

import com.decepticons.assetManagement.entity.RequestStatus;
import com.decepticons.assetManagement.repositories.IDepartmentRepository;
import com.decepticons.assetManagement.services.protocols.IDepartmentManagerService;
import com.decepticons.assetManagement.services.protocols.IDepartmentService;
import com.decepticons.assetManagement.services.protocols.IEmployeeService;
import com.decepticons.assetManagement.services.protocols.IRequestStatusService;




@Controller
@RequestMapping("/requestsstatus")
public class RequestStatusController {

	
	
	@Autowired
	private IRequestStatusService reqstatustypeRepo;

	private List<RequestStatus> requestsstatus;
	
	@PostConstruct
	public void loadData()
	{
		requestsstatus = new ArrayList<RequestStatus>(reqstatustypeRepo.findAll());
	}

	
	@GetMapping("/list")
	public String listRequestStatus(Model model)
	{
		loadData();
		model.addAttribute("requestsstatus", requestsstatus);
		return "list-Requestsstatus";
		
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		RequestStatus req = new RequestStatus();
		model.addAttribute("reqRecord", req);
		return "requestsstatus/RequestsstatusForm";
	}
	
	@PostMapping("/save")
	public String saveRequestData(@ModelAttribute("reqRecord") RequestStatus req)
	{
		reqstatustypeRepo.save(req);
		System.out.println("Saved "+req);
		return "redirect:/requestsstatus/list";
	}

	@GetMapping("/showForForUpdate")
	public String showFormForUpdate(@RequestParam("requeststatus") String requeststatus, Model model)
	{
		RequestStatus req = reqstatustypeRepo.getByRequestStatusId(requeststatus);
		model.addAttribute("reqRecord",req);
		return "requestsstatus/RequestsstatusForm";
	}
//	
	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam String requeststatus, Model model)
	{
		RequestStatus req = reqstatustypeRepo.getByRequestStatusId(requeststatus);
		reqstatustypeRepo.delete(requeststatus);
		System.out.println("Deleted "+req);
		return "redirect:/requestsstatus/list";
	}
}