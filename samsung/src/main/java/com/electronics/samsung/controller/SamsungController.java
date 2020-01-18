package com.electronics.samsung.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SamsungController {

	@PostMapping("M30")
	public List<String> M30(){
		List<String> m30specification = new ArrayList<String>();
		m30specification.add("M30");
		m30specification.add("5`5`` Scree");
		m30specification.add("20MP Front Camera");
		m30specification.add("15MP Back Camera");
		return m30specification;
	}
	
	@PostMapping("M40")
	public List<String> M40(){
		List<String> m30specification = new ArrayList<String>();
		m30specification.add("M40");
		m30specification.add("5`6`` Scree");
		m30specification.add("25MP Front Camera");
		m30specification.add("20MP Back Camera");
		return m30specification;
	}
}
