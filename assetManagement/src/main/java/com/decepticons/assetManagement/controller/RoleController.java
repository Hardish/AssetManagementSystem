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

import com.decepticons.assetManagement.entity.Role;
import com.decepticons.assetManagement.services.protocols.IRoleService;



@Controller
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	
	private List<Role> roles;
	
	@PostConstruct
	public void loadData()
	{
		roles = new ArrayList<Role>(roleService.findAll());
	}

	
	@GetMapping("/list")
	public String listRoles(Model model)
	{
		loadData();
		model.addAttribute("roles", roles);
		return "list-Roles";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		Role role = new Role();
		model.addAttribute("roleRecord", role);
		return "roles/RoleForm";
	}
	
	@PostMapping("/save")
	public String saveRoleeData(@ModelAttribute("roleRecord") Role role)
	{
		roleService.save(role);
		
		System.out.println("Saved "+role);
		return "redirect:/roles/list";
	}
	
	@GetMapping("/showForForUpdate")
	public String showFormForUpdate(@RequestParam("roleid") int Id, Model model)
	{
		Role role = roleService.findById(Id);
		model.addAttribute("roleRecord",role);
		
		return "roles/RoleForm";
	}
	
	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("roleid") int Id, Model model)
	{
		Role role = roleService.findById(Id);
		
		roleService.deleteById(Id);
		
		System.out.println("Deleted "+role);
		return "redirect:/roles/list";
	}
	
	
}
