package com.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.info.dao.ProductRepository;
import com.info.dao.UserRepository;
import com.info.model.Cmd;
import com.info.model.User;
import com.info.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	
	@GetMapping("index")
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("user-list")
	public String userList(Model model) {
		model.addAttribute("userList", userService.findAllUser());
		return "admin/user-list";
	}
	
	@GetMapping("delete-User/{userId}")
	public ModelAndView deleteUser(@PathVariable("userId")String userId) {
		ModelAndView mv = new ModelAndView("admin/user-list");
		userService.deleteUser(Long.parseLong(userId));
		mv.addObject("userList", userService.findAllUser());
		return mv;
	}
	
	@GetMapping("maj-Role/{userId}")
	public ModelAndView selectRole(@PathVariable("userId")String userId) {
		ModelAndView mv = new ModelAndView("admin/updateRole");
		mv.addObject("User", userService.findById(Long.parseLong(userId)).get());
		return mv;
	}
	
	@PostMapping("update-Role")
	public ModelAndView updateRole(String userId,String userRole) {
		ModelAndView mv = new ModelAndView("admin/user-list");
		User user = userService.findById(Long.parseLong(userId)).get();
		user.setRole(userRole);
		userRepository.save(user);
		mv.addObject("userList", userService.findAllUser());
		return mv;
	}
	
	
	@GetMapping("add-user")
	public String addUser() {
		return "admin/add-user";
	}

}
