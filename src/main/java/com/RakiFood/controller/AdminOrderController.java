package com.RakiFood.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.RakiFood.domain.PaymentVO;
import com.RakiFood.dto.Criteria;
import com.RakiFood.dto.PageDTO;
import com.RakiFood.service.AdCartService;
import com.RakiFood.service.AdOrderService;
import com.RakiFood.service.AdmemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@RequestMapping("/admin/order/*")
@Controller
public class AdminOrderController {

	private final AdOrderService adOrderService;
	
	// 주문목록 페이지
	@GetMapping("/order_list")
	public void order_list(Criteria cri, Model model) throws Exception {
		
		cri.setAmount(5);
		
		List<PaymentVO> order_list = adOrderService.order_list(cri);
		
		model.addAttribute("order_list", order_list);
		
		int totalCount = adOrderService.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, totalCount)); 
	}
}
	