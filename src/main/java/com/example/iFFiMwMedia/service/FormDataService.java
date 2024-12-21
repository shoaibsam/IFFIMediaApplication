package com.example.iFFiMwMedia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iFFiMwMedia.model.FormData;
import com.example.iFFiMwMedia.repository.FormDataRepository;


@Service
public class FormDataService {

    @Autowired
    private FormDataRepository formDataRepository;

    public List<FormData> getAllFormData() {
        return formDataRepository.findAll();
    }

    public Optional<FormData> getFormDataById(Long id) {
        return formDataRepository.findById(id);
    }

    public FormData saveFormData(FormData formData) {
        return formDataRepository.save(formData);
    }

    public void deleteFormDataById(Long id) {
        formDataRepository.deleteById(id);
    }
    

	
}
