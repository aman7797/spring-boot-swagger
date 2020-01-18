package com.electronics.mobile.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	@PostMapping("/samsung")
	public List<String> mobile() {
		List<String> samsungList = new ArrayList<String>();
		samsungList.add("M30");
		samsungList.add("M40");
		samsungList.add("M50");
		return samsungList;
		
	}
	
	@PostMapping("/list")
	public List<String> mobileTest() {
		List<String> mobileList = new ArrayList<String>();
		mobileList.add("Mi");
		mobileList.add("Samsung");
		mobileList.add("Nokia");
		return mobileList;
	}
}
