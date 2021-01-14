package com.ba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ba.model.User;
import com.ba.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;	
	
	@GetMapping("users")
    public String show(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
	
	@GetMapping("signup")
	public String showSignUpForm(User user) {
	    return "adduser";
	}
	
	@PostMapping("add")
    public String addStudent(User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }
        userRepository.save(user);
        return "redirect:users";
    }
	
	
	 @GetMapping("edit/{id}")
	    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
	        Optional<User> user = userRepository.findById(id);
	        if(!user.isPresent()) {
	        	throw new IllegalArgumentException("Invalid Student");
	        }
	        
	        model.addAttribute("user", user.get());
	        return "updateUser";
	   }
	 
	@PostMapping("/user/update/{id}")
	public String updateStudent(@PathVariable("id") Integer id, User user, BindingResult result,Model model) {
	    if (result.hasErrors()) {
	    	user.setId(id);
	        return "updateUser";
	    }
	
	    userRepository.save(user);
	    model.addAttribute("users", userRepository.findAll());
	    return "index";
	}


	@GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid student Id:" + id));
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
	
	
	
	
}
