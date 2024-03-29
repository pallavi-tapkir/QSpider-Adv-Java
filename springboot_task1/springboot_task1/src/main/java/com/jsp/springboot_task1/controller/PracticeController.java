package com.jsp.springboot_task1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeController {
	@RequestMapping("/print")
	public void print() {
		System.out.println("Print API is called.");
	}
	
	@RequestMapping("/display")
	public String display() {
		return "Display API is called";
	}
}
