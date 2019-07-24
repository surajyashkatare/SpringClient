package com.suraj.spring.client.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.suraj.spring.client.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping("/addEmp")
	public String addEmpl(@ModelAttribute Employee employee) {
		
		System.out.println(employee);
		return "success";
	}
	
	@RequestMapping("/fetch")
	public String fetchEmp(@PathVariable("id") int id) {
		return "show";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/fetchAll")
	public String fetchAll() {
		
		RestTemplate template=new RestTemplate();
		List<LinkedHashMap<String, Object>> list=template.getForObject("http://localhost:8080/fetchAll", List.class);
		
		for (LinkedHashMap<String, Object> linkedHashMap : list) {
			System.out.println("Employee Id"+linkedHashMap.get("id")+" and Name="+linkedHashMap.get("name"));
		}
		return "show";
	}
	
	@RequestMapping("/delEmp")
	public String delEmp(@PathVariable("id") int id) {
		
		return "success";
	}
}
