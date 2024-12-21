package com.example.iFFiMwMedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.iFFiMwMedia.model.FormData;
import com.example.iFFiMwMedia.repository.FormDataRepository;
import com.example.iFFiMwMedia.service.FormDataService;

@Controller
public class FormController {

	@Autowired
	private FormDataRepository formDataRepository;
	@Autowired
	private FormDataService formDataService;
	
	
	@GetMapping("/home")
	public String showForm() {
		return "index";
	}
	
	@GetMapping("/contactUs")
	public String contactUs() {
		return "contactUs";
	}
	
	@GetMapping("/services")
    public String showServices() {
        return "services"; 
    }
	
	@GetMapping("/about")
	public String showAbout() {
		return "about";
	}

    @PostMapping("/home")
    public String submitForm(FormData formData, Model model) {
        formDataRepository.save(formData);
        model.addAttribute("message", "Form submitted successfully!");
        return "index";
    }
	  
	@GetMapping("/admin-panel")
	public String showAdminPanel(Model model) {
	    List<FormData> formDataList = formDataService.getAllFormData();
	    model.addAttribute("formDataList", formDataList);
	    return "admin_panel";
	}

}
