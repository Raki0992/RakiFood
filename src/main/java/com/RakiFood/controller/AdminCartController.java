package com.RakiFood.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.RakiFood.dto.Criteria;
import com.RakiFood.dto.PageDTO;
import com.RakiFood.dto.RFCartDTO;
import com.RakiFood.service.AdCartService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@RequestMapping("/admin/cart/*")
@Controller
public class AdminCartController {

	private final AdCartService adCartService;

	// 주문목록 페이지
	@GetMapping("/cart_list")
	public void cart_list(Criteria cri, Model model) throws Exception {
		
	}
}
