package com.decepticons.assetManagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.entity.UserAuth;
import com.decepticons.assetManagement.repositories.IEmployeeRepository;
import com.decepticons.assetManagement.services.protocols.IEmployeeService;
import com.decepticons.assetManagement.services.protocols.IUserAuthService;
import com.decepticons.assetManagement.util.AssetManagementUtil;


@Controller
@RequestMapping("/userAuth")
@Scope("session")
@SessionAttributes("user")
public class UserAuthController {

	
	
	@Autowired
	private IUserAuthService uAuthService;
	
	@Autowired
	private IEmployeeService empService;
	
	private List<UserAuth> userCredentials;
	
	@PostConstruct
	public void loadData()
	{
		userCredentials = new ArrayList<UserAuth>(uAuthService.findAll());
	}

	@GetMapping("/login")
	public String requestLogin(Model model)
	{
		System.out.println("from user auth");
		return "userAuth/Login";
	}
	
	@PostMapping("/login")
	public String authenticateUser(@RequestParam("userName") String userName,@RequestParam("password") String password, Model model)
	{
		String nextPage="userAuth/Login";//redirect:/Login.html?loginError=true";
		String loginMessage="The userID or password is incorrect!";
		
		System.out.println(" userName "+userName+" password "+password);
		
		//System.out.println(uAuthService.findAll());
		UserAuth  user = uAuthService.findByUserName(userName);
		
		if(user !=null)
		{
			System.out.println("user "+user+" password match "+(user.getPassword().equals(password)));
			if(user.getPassword().equals(password))
			{
				loginMessage="Success!";
				setUserAuth(user);
				nextPage = "/main/Home";			
			}
			else
			{
			loginMessage="The password is incorrect ";
			}
		}
		
		model.addAttribute("loginErrorMsg", loginMessage);
		System.out.println(" user "+user+" nextPage "+nextPage );
		return nextPage;
	}
	
	//set session user
	@ModelAttribute("user")
	public Employee setUserAuth(UserAuth user) {
		
		Employee emp = empService.findByUserName(user.getUserName());
		System.out.println("setting session "+emp);
		return emp;
	}
	
	/*
	 *   <frame src="http://localhost:8080/userAuth/Header" name="head">
        <frameset cols="10%,90%">
            <frame src="http://localhost:8080/userAuth/SideMenu" name="SIDE">
                <frame src="http://localhost:8080/userAuth/Body" name="MAIN">
        </frameset>
        <frame src="http://localhost:8080/userAuth/Bottom" name="bottom">
	 */
	
	//start homepage - html
	@GetMapping("Header")
	public String getHeader(Model model)
	{
		return "/main/Header";
	}
	
	@GetMapping("SideMenu")
	public String getSideMenu(@SessionAttribute("user") Employee user, Model model )
	{
		System.out.println(" MOdel -- user :"+user);
		
		model.addAttribute("employee", user);
		
		return "/main/SideMenu";
	}
	
	@GetMapping("Body")
	public String getMainBody(Model model)
	{
		return "redirect:http://localhost:8080/employees/list";
	}
	
	@GetMapping("Bottom")
	public String getFooter(Model model)
	{
		return "/main/Bottom";
	}
	
	//stop homepage - html
	
	@GetMapping("/list")
	public String listUserAuths(Model model)
	{
		loadData();
		model.addAttribute("userCredentials", userCredentials);
		return "list-UserAuth";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		UserAuth userAuth = new UserAuth();
//		userAuth.setUserName(userName);
//		userAuth.setPassword(userName);
		
		model.addAttribute("empRecord", userAuth);
		
		return "userAuth/UserAuthForm";
	}
	
	@PostMapping("/save")
	public String saveUserAuthData(@ModelAttribute("empRecord") UserAuth userAuth)
	{
		
		System.out.println("saving.. "+userAuth);
		
		uAuthService.save(userAuth);
		
		System.out.println("Saved "+userAuth);
		return "redirect:/userAuth/list";
	}
	
	@GetMapping("/showForForUpdate")
	public String showFormForUpdate(@RequestParam("Id") String Id, Model model)
	{
		UserAuth userAuth = uAuthService.findById(Id);
		
		System.out.println("Saved "+userAuth);
		
		model.addAttribute("empRecord",userAuth);
		
		return "userAuth/UserAuthForm";
	}
	
	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("Id") String Id, Model model)
	{
		UserAuth userAuth = uAuthService.findById(Id);
		
		uAuthService.deleteById(Id);
		
		System.out.println("Deleted "+userAuth);
		return "redirect:/userAuth/list";
	}
	
	
}
