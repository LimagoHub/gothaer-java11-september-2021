package com.example.httpdemo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@GetMapping("/add/{a}/{b}")
	public int getAdd(@PathVariable int a, @PathVariable int b) {
		return a + b;
	}
	
	@PostMapping(path= "/add")
	public int postAdd(@RequestBody Parameter p) {
		return p.getA() + p.getB();
	}

}
