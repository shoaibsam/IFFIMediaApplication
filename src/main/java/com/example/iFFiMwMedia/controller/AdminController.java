package com.example.iFFiMwMedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iFFiMwMedia.model.FormData;
import com.example.iFFiMwMedia.service.FormDataService;

@RestController
@RequestMapping("/api/admin/form-data")
public class AdminController {

    @Autowired
    private FormDataService formDataService;

    @GetMapping
    public List<FormData> getAllFormData() {
        return formDataService.getAllFormData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormData> getFormDataById(@PathVariable Long id) {
        return formDataService.getFormDataById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @GetMapping("/admin-panel")
	public String showAdminPanel(Model model) {
	    List<FormData> formDataList = formDataService.getAllFormData();
	    model.addAttribute("formDataList", formDataList);
	    return "admin_panel";
	}
    
    
}
