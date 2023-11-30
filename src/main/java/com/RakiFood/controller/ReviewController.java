package com.RakiFood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RakiFood.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/user/review*")
@RequiredArgsConstructor
public class ReviewController {
	
	private final ReviewService reviewService;

	// /user/product/pro_detail?pageNum=1&amount=4&type=&keyword=&cg_code=5&cg_name=%EA%B9%80%EB%B0%A5&pro_num=22
//	@GetMapping("/list/{pro_num}")
//	public 
}
