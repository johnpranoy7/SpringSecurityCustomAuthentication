package com.john.graphite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@GetMapping("/world")
	public String world() {
		return "world";
	}
}
